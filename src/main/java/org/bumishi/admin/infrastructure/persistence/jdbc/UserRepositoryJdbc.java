package org.bumishi.admin.infrastructure.persistence.jdbc;

import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.domain.modle.Resource;
import org.bumishi.admin.domain.modle.Role;
import org.bumishi.admin.domain.modle.User;
import org.bumishi.admin.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@Repository
public class UserRepositoryJdbc implements UserRepository {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        jdbcTemplate.update("INSERT user (id,username,password,email,disabled,createTime) VALUES (?,?,?,?,?,?)",user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),user.isDisabled()?1:0,new Date());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE user SET username=?,email=?,password=? WHERE id=?",user.getUsername(),user.getEmail(),user.getPassword(),user.getId());
        if(!CollectionUtils.isEmpty(user.getRoles())){
            jdbcTemplate.update("DELETE FROM user_role WHERE uid=?",user.getId());
            jdbcTemplate.batchUpdate("INSERT user_role (uid,role_id) VALUES (?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,user.getId());
                    ps.setString(2,user.getRoles().get(i));
                }

                @Override
                public int getBatchSize() {
                    return user.getRoles().size();
                }
            });
        }
    }

    @Override
    public User get(String id) {
        return jdbcTemplate.queryForObject("select * from user where id=?", BeanPropertyRowMapper.newInstance(User.class),id);
    }

    @Override
    public boolean contains(String name) {
        return jdbcTemplate.query("select count(username) from user where username=?", rs -> rs.getInt(1)>0,name);
    }

    @Override
    public List<User> list() {
        return jdbcTemplate.query("select * from user where username <> 'root'", BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public List<Resource> getUrlResources(String userId) {
        return jdbcTemplate.query("select r.* from resource r join role_resource rr on r.id=rr.resource_id join user_role ur on rr.role_id=ur.role_id where ur.uid=?",BeanPropertyRowMapper.newInstance(Resource.class),userId);
    }

    @Override
    public boolean hasResourcePermission(String uid,String resourceCode) {
        return jdbcTemplate.query("select count(*) from user_role ur join role_resource rr on ur.role_id=rr.role_id where ur.uid=? and rr.resource_id=?",rs -> rs.getInt(0)>0,uid,resourceCode);
    }

    @Override
    public List<Menu> getNavMenus(String userId) {
        return jdbcTemplate.query("select m.* from menu m join role_menu rm on m.code=rm.menu_code join user_role ur on rm.role_id=ur.role_id where m.disabled=0 and ur.uid=?", (rs, rowNum) -> {
            Menu menu = new Menu(rs.getString("code"), rs.getString("label"), rs.getString("url"));
            menu.setDisabled(rs.getBoolean("disabled"));
            menu.parseItemsFromJson(rs.getString("items"));
            return menu;
        },userId);
    }

    @Override
    public void remove(String id) {
        User user=get(id);
        if(user.isRoot()){
            return;
        }
        jdbcTemplate.update("DELETE FROM user WHERE id=?",id);
        jdbcTemplate.update("DELETE FROM user_role WHERE uid=?",id);
        //jdbcTemplate.update("DELETE FROM user_menu WHERE uid=?",id);
    }

    public void switchStatus(String id,boolean disabled){
        jdbcTemplate.update("update user SET disabled=? WHERE id=?",disabled?1:0,id);
    }


    @Override
    public User findByUserName(String username) {
        try {
            return jdbcTemplate.queryForObject("select * from user where username=? ", BeanPropertyRowMapper.newInstance(User.class), username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Role> getRoles(String userId) {
        return jdbcTemplate.query("select * from role r join user_role ur on r.id=ur.role_id where ur.uid=?",BeanPropertyRowMapper.newInstance(Role.class),userId);
    }
}

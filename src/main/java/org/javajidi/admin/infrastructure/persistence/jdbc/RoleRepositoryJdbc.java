package org.javajidi.admin.infrastructure.persistence.jdbc;

import org.javajidi.admin.domain.modle.Role;
import org.javajidi.admin.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@Repository
public class RoleRepositoryJdbc implements RoleRepository {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public void add(Role role) {
       jdbcTemplate.update("INSERT role (id,`name`,disabled,description) VALUES (?,?,?,?)",role.getId(),role.getName(),role.isDisabled()?1:0,role.getDescription());
    }

    @Override
    public void update(Role role) {
        jdbcTemplate.update("update role SET `name` =?,disabled=?,description=? WHERE id=?",role.getName(),role.isDisabled()?1:0,role.getDescription(),role.getId());
        if(!CollectionUtils.isEmpty(role.getMenus())){
            jdbcTemplate.update("DELETE FROM role_menu WHERE role_id=?",role.getId());
            jdbcTemplate.batchUpdate("INSERT role_menu (role_id,menu_code) VALUES (?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,role.getId());
                    ps.setString(2,role.getMenus().get(i));
                }

                @Override
                public int getBatchSize() {
                    return role.getMenus().size();
                }
            });
        }

        if(!CollectionUtils.isEmpty(role.getResources())){
            jdbcTemplate.update("DELETE FROM role_resource WHERE role_id=?",role.getId());
            jdbcTemplate.batchUpdate("INSERT role_resource (role_id,resource_code) VALUES (?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,role.getId());
                    ps.setString(2,role.getResources().get(i));
                }

                @Override
                public int getBatchSize() {
                    return role.getResources().size();
                }
            });
        }


    }

    @Override
    public boolean contains(String roleName) {
        return jdbcTemplate.query("select count(`name`) from role where `name`=?", rs -> rs.getInt("name")>0,roleName);
    }

    @Override
    public Role get(String id) {
        return jdbcTemplate.queryForObject("select * from role where id=?", BeanPropertyRowMapper.newInstance(Role.class),id);
    }

    @Override
    public List<Role> list() {
        return jdbcTemplate.query("select * from role",BeanPropertyRowMapper.newInstance(Role.class));
    }

    @Override
    public void remove(String id) {
        jdbcTemplate.update("DELETE FROM role WHERE id=?",id);
    }

    public void switchStatus(String id,boolean disabled){
        jdbcTemplate.update("update role SET disable=? WHERE id=?",disabled?1:0,id);
    }
}

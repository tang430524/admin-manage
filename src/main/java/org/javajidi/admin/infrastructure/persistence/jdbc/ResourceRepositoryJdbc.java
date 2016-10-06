package org.javajidi.admin.infrastructure.persistence.jdbc;

import org.javajidi.admin.domain.modle.Resource;
import org.javajidi.admin.domain.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@Repository
public class ResourceRepositoryJdbc implements ResourceRepository{

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public void add(Resource resource) {
        jdbcTemplate.update("INSERT INTO resource (code,title,type,disabled,url,description) VALUES (?,?,?,?,?,?)",resource.getCode(),resource.getTitle(),resource.getType(),resource.isDisabled()?1:0,resource.getUrl(),resource.getDescription());
    }

    @Override
    public void update(Resource resource) {
        jdbcTemplate.update("UPDATE resource title=?,`type`=?,disabled=?,url=?,description=? WHERE code=?) VALUES (?,?,?,?,?,?)",resource.getTitle(),resource.getType(),resource.isDisabled()?1:0,resource.getUrl(),resource.getDescription(),resource.getCode());
    }

    @Override
    public Resource get(String code) {
        return jdbcTemplate.queryForObject("select * from resource where code=?",BeanPropertyRowMapper.newInstance(Resource.class),code);
    }

    @Override
    public List<Resource> list() {
        return jdbcTemplate.query("select * from resource",BeanPropertyRowMapper.newInstance(Resource.class));
    }

    @Override
    public void remove(String code) {
        jdbcTemplate.update("DELETE FROM resource WHERE code=?",code);
    }

    public void switchStatus(String code,boolean disabled){
        jdbcTemplate.update("update resource SET disabled=? WHERE code=?",disabled?1:0,code);
    }


    @Override
    public List<Resource> listByRole(String roleId) {
        return jdbcTemplate.query("select re.* from  role_resource rr  join resources re on re.code=rr.resource_code where rr.role_id=?",BeanPropertyRowMapper.newInstance(Resource.class),roleId);
    }
}

package org.javajidi.admin.infrastructure.persistence.jdbc;

import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.domain.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@Repository
public class MenuRepositoryJdbc implements MenuRepository{

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public void add(Menu menu) {
        jdbcTemplate.update("INSERT menu (code,label,url,disaled,items) VALUES (?,?,?,?,?)",menu.getCode(),menu.getLabel(),menu.getUrl(),menu.isDisabled()?1:0,menu.itemsToJson());
    }

    @Override
    public void update(Menu menu) {
        jdbcTemplate.update("update menu SET label=?,url=?,disabled=?,items=? WHERE code=?",menu.getLabel(),menu.getUrl(),menu.isDisabled()?1:0,menu.itemsToJson(),menu.getCode());
    }

    @Override
    public Menu get(String code) {
        return jdbcTemplate.queryForObject("select * from menu where code=?",createMapper(),code);
    }

    @Override
    public boolean contains(String code) {
        return jdbcTemplate.query("select count(code) from menu where code=?", rs -> rs.getInt("code")>0,code);
    }

    @Override
    public List<Menu> list() {
        return jdbcTemplate.query("select * from menu",createMapper());
    }

    @Override
    public void remove(String code) {
        jdbcTemplate.update("DELETE FROM menu WHERE code=?",code);
    }

    public void switchStatus(String code,boolean disabled){
        jdbcTemplate.update("update menu SET disable=? WHERE code=?",disabled?1:0,code);
    }

    private RowMapper<Menu> createMapper() {
        return (rs, rowNum) -> {
            Menu menu = new Menu(rs.getString("code"), rs.getString("label"), rs.getString("url"));
            menu.setDisabled(rs.getBoolean("disabled"));
            menu.parseItemsFromJson(rs.getString("items"));
            return menu;
        };
    }
}

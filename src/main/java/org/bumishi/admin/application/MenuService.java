package org.bumishi.admin.application;

import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.domain.modle.TreeModel;
import org.bumishi.admin.domain.repository.MenuRepository;
import org.bumishi.admin.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
@CacheConfig(cacheNames = "menulist")
public class MenuService {

    @Autowired
    protected MenuRepository menuRepository;

    @Autowired
    protected RoleRepository roleRepository;

    /*cache操作相关的注解中key都是spel表达式，字符串需要用''*/
    @Caching(
            put = @CachePut(key = "#menu.id"),
            evict = @CacheEvict(key = "'list'")
    )
    public Menu create(Menu menu) {
        validate(menu);
        menuRepository.add(menu);
        return menu;
    }

    @Caching(
            put = @CachePut(key = "#menu.id"),
            evict = @CacheEvict(key = "'list'")
    )
    public Menu modify(Menu menu) {
        validate(menu);
        menuRepository.update(menu);
        return menu;
    }


    @Cacheable
    public Menu get(String code) {
        return menuRepository.get(code);
    }

    @Caching(
            evict = {@CacheEvict(key = "'list'"), @CacheEvict(key = "#code")}
    )
    public void delete(String code) {
        roleRepository.removeRoleMenuByMenuId(code);
        menuRepository.remove(code);
    }

    @Cacheable(key = "'list'")
    public List<Menu> list() {
        List<Menu> list = menuRepository.list();
        TreeModel.sortByTree(list);
        return list;
    }

    @Caching(
            evict = {@CacheEvict(key = "'list'"), @CacheEvict(key = "#menu.id")}
    )
    public void switchStatus(String menu, boolean disable) {
        menuRepository.switchStatus(menu, disable);
    }

    private void validate(Menu menu) {
        Assert.hasText(menu.getId());
        Assert.hasText(menu.getLabel());
    }

}

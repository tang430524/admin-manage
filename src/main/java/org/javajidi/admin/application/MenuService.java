package org.javajidi.admin.application;

import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.domain.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class MenuService {

    @Autowired
    protected MenuRepository menuRepository;

    public void create(Menu menu){
        if(menuRepository.contains(menu.getCode())){
            return;
        }
        menuRepository.add(menu);
    }

    public void modify(Menu menu){
        menuRepository.update(menu);
    }

    public Menu get(String code){
        return menuRepository.get(code);
    }

    public void delete(String code){
        menuRepository.remove(code);
    }


}

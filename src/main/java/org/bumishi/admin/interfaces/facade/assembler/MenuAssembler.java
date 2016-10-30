package org.bumishi.admin.interfaces.facade.assembler;

import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.infrastructure.BeanUtil;
import org.bumishi.admin.interfaces.commondobject.MenuCreateCommand;
import org.bumishi.admin.interfaces.commondobject.MenuUpdateCommond;

/**
 * Created by xieqiang on 2016/10/30.
 */
public class MenuAssembler {

    public static Menu updateCommendToDomain(MenuUpdateCommond updateCommond){
        Menu menu=new Menu();
      BeanUtil.copeProperties(updateCommond,menu);
        return menu;
    }

    public static Menu createCommendToDomain(MenuCreateCommand creteCommand){
        Menu menu=new Menu();
        BeanUtil.copeProperties(creteCommand,menu);
        return menu;
    }
}

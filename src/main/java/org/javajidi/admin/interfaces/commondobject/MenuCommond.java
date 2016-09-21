package org.javajidi.admin.interfaces.commondobject;

import org.javajidi.admin.domain.modle.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/19
 */
public class MenuCommond {

    /** 唯一代码*/
    private String code;

    /**显示名称*/
    private String label;

    /**链接*/
    private String url;

    /**子菜单,只支持二级菜单*/
    private List<Menu> items=new ArrayList<>();

}

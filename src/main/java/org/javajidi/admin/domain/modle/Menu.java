package org.javajidi.admin.domain.modle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 * 菜单
 */
public class Menu {


    //唯一代码
    private String code;

    //显示名称
    private String label;

    //链接
    private String url;

    /** 状态 是否禁用*/
    private boolean disabled;

    //子菜单
    private List<Menu> items=new ArrayList<>();

    public Menu(String code,String label){
        this.code=code;
        this.label=label;
    }

    public Menu(String code,String label,String url){
        this(code, label);
        this.url=url;
    }


    public void addItems(Menu menu){
        items.add(menu);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }
}

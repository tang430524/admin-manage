package org.bumishi.admin.domain.modle;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 * 菜单
 */
public class Menu {


    /** 唯一代码*/
    private String code;

    /**显示名称*/
    private String label;

    /**链接*/
    private String url;

    /** 状态 是否禁用*/
    private boolean disabled;

    /**子菜单,只支持二级菜单*/
    private List<Menu> items=new ArrayList<>();

    public Menu(){

    }
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

    public String itemsToJson(){
        if(CollectionUtils.isEmpty(items)){
            return null;
        }
        return JSON.toJSONString(items);
    }

    public void parseItemsFromJson(String jsonItems){
        items=JSON.parseArray(jsonItems,Menu.class);
    }
}

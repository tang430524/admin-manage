package org.bumishi.admin.interfaces.commondobject;

/**
 * Created by xieqiang on 2016/10/30.
 */
public class MenuUpdateCommond {

    private String label;
    private String url;
    private int order;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

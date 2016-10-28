package org.bumishi.admin.domain.modle;

/**
 * @author qiang.xie
 * @date 2016/10/28
 */
public class SelectResource {

    private String rid;//resource id

    private String label;

    private boolean checked;

    public SelectResource() {
    }

    public SelectResource(String rid, String label, boolean checked) {
        this.rid = rid;
        this.label = label;
        this.checked = checked;
    }

    public String getLabel() {
        return label;
    }

    public String getRid() {
        return rid;
    }

    public boolean isChecked() {
        return checked;
    }


}

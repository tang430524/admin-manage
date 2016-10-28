package org.bumishi.admin.domain.modle;

/**
 * 用户分配角色功能中列出角色，用户已经具备的角色checked=true
 *
 * @author qiang.xie
 * @date 2016/10/28
 */
public class SelectRole {

    private String rid;//role id

    private String name;//role name

    private boolean checked;

    public SelectRole() {
    }

    public SelectRole(String rid, String name, boolean checked) {
        this.rid = rid;
        this.name = name;
        this.checked = checked;
    }

    public String getRid() {
        return rid;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getName() {
        return name;
    }

}

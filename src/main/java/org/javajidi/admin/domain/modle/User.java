package org.javajidi.admin.domain.modle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * 用户
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键ID */
	private String id;

	/** 登录名称 */
	private String loginName;

	/** 密码 */
	private String password;

	/**密码加密的盐*/
	private String salt;

	/** 邮箱 */
	private String email;

	/** 是否禁用 */
	private boolean disabled;

	/** 创建时间 */
	private Date createTime;

	/** 最后登录时间 */
	private Date lastTime;

	private List<String> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public void grantRoles(List<String> roles){
		this.roles=roles;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isRoot(){
		return "root".equals(loginName);
	}
}

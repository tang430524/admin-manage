package org.javajidi.admin.modle;

import java.io.Serializable;

/**
 *
 * 角色权限
 *
 */
public class RolePermission implements Serializable {

	/** 主键 */
	private Long id;

	/** 角色ID */
	private Long rid;

	/** 权限ID */
	private Long pid;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}

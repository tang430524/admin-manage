package org.javajidi.admin.domain.modle;

import java.io.Serializable;

/**
 *
 * 用户角色映射
 *
 */
public class UserRole implements Serializable {

	/** 主键 */
	private int id;

	/** 用户ID */
	private int uid;

	/** 角色ID */
	private int rid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}

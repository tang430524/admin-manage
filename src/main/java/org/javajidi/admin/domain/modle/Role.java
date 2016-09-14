package org.javajidi.admin.domain.modle;

import java.io.Serializable;

/**
 *
 * 角色
 *
 */
public class Role implements Serializable {

	/** 主键 */
	private int id;

	/** 角色 */
	private String name;

	/** 描述 */
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

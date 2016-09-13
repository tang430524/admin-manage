package org.javajidi.admin.modle;

import java.io.Serializable;

/**
 *
 * 角色
 *
 */
public class Role implements Serializable {

	/** 主键 */
	private Long id;

	/** 角色 */
	private String name;

	/** 排序 */
	private Integer sort;

	/** 描述 */
	private String description;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

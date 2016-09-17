package org.javajidi.admin.domain.modle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * 角色
 *
 */
public class Role implements Serializable {

	private String id;

	/** 角色名*/
	private String name;

	/** 描述 */
	private String description;

	/** 状态 是否禁用*/
	private boolean disabled;

	private List<Resource> resources;

	private List<Menu> menus;

	public Role(String id,String name,String desc){
		this.name=name;
		this.description=desc;
		this.id=id;
	}


	public Role setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Role setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getName() {
		return name;
	}

	public void update(String name,String desc){
		this.setName(name).setDescription(desc);
	}

	public void grantResource(List<Resource> resources){
		this.resources=resources;
	}

	public void grantMenu(List<Menu> menus){
		this.menus=menus;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getId() {
		return id;
	}

	public Role setId(String id) {
		this.id = id;
		return this;
	}
}

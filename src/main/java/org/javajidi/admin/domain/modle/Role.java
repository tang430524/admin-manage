package org.javajidi.admin.domain.modle;

import java.io.Serializable;
import java.util.List;

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


	//todo 这两个字段待商榷

	/**资源id*/
	private List<String> resources;

	/**菜单id*/
	private List<String> menus;


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

	public void grantResource(List<String> resources){
		this.resources=resources;
	}

	public void grantMenu(List<String> menus){
		this.menus=menus;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}



	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

	public String getId() {
		return id;
	}

	public Role setId(String id) {
		this.id = id;
		return this;
	}

	public List<String> getResources() {
		return resources;
	}
}


package org.javajidi.admin.domain.modle;

import java.io.Serializable;

/**
 *
 * 资源
 *
 * 菜单，服务地址，功能按钮，某个数据都是资源
 */
public class Resource implements Serializable {

	private int id;

	/** 权限名称 */
	private String title;

	/** 资源类型 1. 菜单 2. 功能按钮、3. url 4.数据 */
	private byte type;

	/** 状态 是否启用*/
	private boolean disabled;

	/** 地址 */
	private String url;

	/** 权限编码 */
	private String permCode;


	/** 描述 */
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermCode() {
		return permCode;
	}

	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

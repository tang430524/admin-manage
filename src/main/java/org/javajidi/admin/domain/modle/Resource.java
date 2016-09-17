package org.javajidi.admin.domain.modle;

import java.io.Serializable;

/**
 *
 * 资源
 *
 * 服务地址，功能按钮，某个数据都是资源
 */
public class Resource implements Serializable {

	/** 唯一权限编码 */
	private String code;

	/** 权限名称 */
	private String title;

	/** 资源类型 1. 功能按钮、2. url 3.数据 */
	private byte type;

	/** 状态 是否禁用*/
	private boolean disabled;

	/** 地址 */
	private String url;

	/** 描述 */
	private String description;


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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}

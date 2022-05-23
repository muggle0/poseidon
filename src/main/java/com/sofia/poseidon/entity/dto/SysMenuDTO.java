package com.sofia.poseidon.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SysMenuDTO implements Serializable {

	private String id;
	private String name;
	private String title;
	private String parentId;
	private String icon;
	private String path;
	private Integer type;
	private String component;
	private Integer statu;

	@NotBlank(message = "菜单授权码不能为空")
	private String permission;

	private Integer orderNum;

	private List<SysMenuDTO> children = new ArrayList<>();

}

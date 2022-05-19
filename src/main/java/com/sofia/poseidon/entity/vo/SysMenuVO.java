package com.sofia.poseidon.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.sofia.poseidon.entity.pojo.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Date 2022/5/14
 * Created by muggle
 */
public class SysMenuVO {

    /**
     * 菜单URL
     */
    private String path;

    private String permission;

    private String component;

    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    @TableField("orderNum")
    private Integer orderNum;

    private Long id;

    private List<SysMenuVO> children = new ArrayList<>();
}

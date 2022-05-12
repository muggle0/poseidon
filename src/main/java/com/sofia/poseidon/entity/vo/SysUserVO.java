package com.sofia.poseidon.entity.vo;

import com.sofia.poseidon.entity.dto.SysMenuDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Description
 * Date 2021/11/3
 * Created by muggle
 */
@Data
public class SysUserVO {
    private String username;

    private Long id;

    private String avatar;

    private LocalDateTime created;

    private List<SysMenuDTO> nav;

    private List<String> authoritys;
}

package com.muggle.poseidon.entity.dto;

import lombok.Data;

@Data
public class MessagePrincipal {
    private String username;
    private String verification;
    private Integer code;
}

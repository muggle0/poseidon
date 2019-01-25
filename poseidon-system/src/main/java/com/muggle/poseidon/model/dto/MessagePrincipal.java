package com.muggle.poseidon.model.dto;

import lombok.Data;

@Data
public class MessagePrincipal {
    private String username;
    private String verification;
    private Integer code;
}

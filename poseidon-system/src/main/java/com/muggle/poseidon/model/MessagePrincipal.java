package com.muggle.poseidon.model;

import lombok.Data;

@Data
public class MessagePrincipal {
    private String principal;
    private String verification;
    private Integer code;
}

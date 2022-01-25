package com.ws.entity.dto;

import com.ws.util.StatusOrder;

import lombok.Data;

@Data
public class StatusRequest {
    private Long id;
    private StatusOrder statusOrder;
}

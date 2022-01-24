package com.ws.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusOrder {

    EARRING("PENDIENTE"),
    COMPLETED("COMPLETADO"),
    REJECTED("RECHAZADO");

    private final String status;
}

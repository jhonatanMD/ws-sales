package com.ws.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusProduct {

    ACTIVED("ACTIVADO",0),
    DELETED("ELIMINADO",1);

    private final String status;
    private final int code;
}

package org.lmrl.gifnoc.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResultInfo {
    USER_NOT_FOUND(9000, ""),
    USER_NOT_ENABLED(9001, "");
    public final int code;
    public final String message;
}

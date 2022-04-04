package io.miya.blog.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(1,"成功"),
    ERROR(-1,"失败");
    private Integer code;
    private String message;
}

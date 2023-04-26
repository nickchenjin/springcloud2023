package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classname:CommonResult
 * Package:org.example.entities
 * Description:
 *
 * @param <T> the type parameter
 * @Author:NickChJ
 * @Create:2023/4/10 - 16:57
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code , String message)
    {
        this(code , message,null);
    }
}

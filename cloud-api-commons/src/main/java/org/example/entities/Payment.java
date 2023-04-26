package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Classname:Payment
 * Package:org.example.entities
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 16:54
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {
    private Long id;
    private String serial;
}

package com.rocky.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistLoginBO {

    /**
     * 注册登录传递的邮件地址和密码BO
     */
    @NotBlank(message = "邮件不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;

}

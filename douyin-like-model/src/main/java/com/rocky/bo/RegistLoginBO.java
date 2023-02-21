package com.rocky.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistLoginBO {

    /**
     * 注册登录传递的邮件地址和密码BO
     */

    private String email;

    private String password;



}

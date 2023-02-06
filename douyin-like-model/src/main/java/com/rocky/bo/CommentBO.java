package com.rocky.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Netter
 * @date: 2023-02-05 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentBO {

    private long uid;

    private long vid;

    private long cid;

    private Byte commentStatus;

    private String content;

}

package com.rocky.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoBO {

    private long uid;
    // author

    private String title;

    private String playUrl;

    private String coverUrl;

    private byte videoStatus;

}

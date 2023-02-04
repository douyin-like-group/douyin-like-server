package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoVO {

    private long id;

    private UsersVO author;

    @JsonProperty("play_url")
    private String playUrl;

    @JsonProperty("cover_url")
    private String coverUrl;

    @JsonProperty("favorite_count")
    private long favoriteCount;

    @JsonProperty("comment_count")
    private long commentCount;

    @JsonProperty("is_favorite")
    private boolean is_favorite;

    private String title;
}

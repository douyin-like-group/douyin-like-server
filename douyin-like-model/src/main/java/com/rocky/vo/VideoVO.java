package com.rocky.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rocky.pojo.Users;
import com.rocky.pojo.Video;
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
    private boolean isFavorite;

    private String title;

    public VideoVO(Video video,
                   UsersVO usersVO,
                   long favoriteCount,
                   long commentCount,
                   boolean isFavorite){

        this.id = video.getId();
        this.author = usersVO;
        this.playUrl=video.getPlayUrl();
        this.coverUrl=video.getCoverUrl();
        this.title=video.getTitle();
        this.favoriteCount=favoriteCount;
        this.commentCount=commentCount;
        this.isFavorite=isFavorite;

    }
}

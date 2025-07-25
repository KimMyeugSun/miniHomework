package com.kh.miniHomework.plave;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoverMusicVo {
    private int coverNo;
    private int no;
    private String title;
    private String originalArtist;
    private String youtubeUrl;
    private String thumbnailUrl;
    private String delYn;
}

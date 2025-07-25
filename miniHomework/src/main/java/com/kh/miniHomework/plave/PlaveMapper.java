package com.kh.miniHomework.plave;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PlaveMapper {

    @Insert("""
            INSERT INTO COVER_SONG (
              COVER_NO,
              NO,
              TITLE,
              ORIGINAL_ARTIST,
              YOUTUBE_URL,
              THUMBNAIL_URL
            ) VALUES (
              SEQ_CM.NEXTVAL,
              #{no},
              #{title},
              NVL2(#{originalArtist}, #{originalArtist}, ORIGINAL_ARTIST)
              #{youtubeUrl},
              #{thumbnailUrl}
            )
            """)
    int insertMusic(CoverMusicVo vo);


    @Select("""
            SELECT
                COVER_NO
                NO,
                TITLE
            FROM
                COVER_MUSIC
            WHERE
                NO = #{no}
              AND DEL_YN = 'N'
            ORDER BY COVER_NO DESC
            """)
    List<CoverMusicVo> selectMusicList();

    @Select("""
            SELECT
                COVER_NO
                NO,
                TITLE
            FROM
                COVER_MUSIC
            WHERE
                NO = #{no}
              AND DEL_YN = 'N'
            ORDER BY COVER_NO DESC
            """)
    CoverMusicVo selectMusicOne(int no);


    @Select("""
            SELECT
            NO
            , NAME
            FROM PLAVE
            WHERE NO = #{no}
            """)
    PlaveVo selectPlaveOne(String no);

    @Update("""
            UPDATE COVER_MUSIC
            SET
                NO = NVL2(#{no}, #{no}, NO),
                TITLE = NVL2(#{title}, #{title}, TITLE),
                YOUTUBE_URL = NVL2(#{youtubeUrl}, #{youtubeUrl}, YOUTUBE_URL),
                THUMBNAIL_URL = NVL2(#{thumbnailUrl}, #{thumbnailUrl}, THUMBNAIL_URL)
            WHERE
                COVER_NO = #{coverNo}
                AND DEL_YN = 'N';
            """)
    CoverMusicVo modifyMusic(CoverMusicVo vo);

    @Update("""
            UPDATE COVER_MUSIC
            SET
            DEL_YN = 'Y'
            WHERE
            COVER_NO = #{coverNo}
            """)
    int delectMusic(CoverMusicVo vo);
}

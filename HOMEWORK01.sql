DROP SEQUENCE SEQ_P;
CREATE SEQUENCE SEQ_P NOCYCLE NOCACHE;
DROP TABLE PLAVE CASCADE CONSTRAINTS;
CREATE TABLE PLAVE (
    NO          NUMBER              PRIMARY KEY
    , NAME     VARCHAR2(100)    NOT NULL
    , AGE        NUMBER              NOT NULL 
    , NICK       VARCHAR2(100) 
    , BIRTH      VARCHAR2(50)
    , MBTI       VARCHAR2(4)
);
DROP SEQUENCE SEQ_CM;
CREATE SEQUENCE SEQ_CM NOCYCLE NOCACHE;
DROP TABLE COVER_MUSIC CASCADE CONSTRAINTS;
CREATE TABLE COVER_MUSIC (
    COVER_NO       NUMBER            PRIMARY KEY,
    NO     NUMBER            NOT NULL, -- 외래키
    TITLE          VARCHAR2(200)     NOT NULL,
    YOUTUBE_URL    VARCHAR2(300),
    THUMBNAIL_URL  VARCHAR2(300),
    DEL_YN         CHAR(1) DEFAULT 'N' CHECK (DEL_YN IN ('Y','N')),
    FOREIGN KEY (NO) REFERENCES PLAVE(NO)
);


INSERT INTO PLAVE (NO, NAME, AGE, NICK, BIRTH, MBTI) VALUES 
(SEQ_P.NEXTVAL, '노아', 23, '패근', '2001-02-10', 'ISFJ');

INSERT INTO PLAVE (NO, NAME, AGE, NICK, BIRTH, MBTI) VALUES 
(SEQ_P.NEXTVAL, '은호', 20, '차늑왕', '2003-05-23', 'ENTP');

INSERT INTO PLAVE (NO, NAME, AGE, NICK, BIRTH, MBTI) VALUES 
(SEQ_P.NEXTVAL, '하민', 0, '곰', '0000-11-01', 'INFJ');

INSERT INTO PLAVE (NO, NAME, AGE, NICK, BIRTH, MBTI) VALUES 
(SEQ_P.NEXTVAL, '밤비', 21, '테겐다람쥐', '2002-07-15', 'INTJ');

INSERT INTO PLAVE (NO, NAME, AGE, NICK, BIRTH, MBTI) VALUES 
(SEQ_P.NEXTVAL, '예준', 22, '돌끼', '2001-09-12', 'ISTJ');
INSERT INTO PLAVE (NO, NAME, AGE) VALUES 
(SEQ_P.NEXTVAL, '전체',0);

INSERT INTO COVER_MUSIC
    (COVER_NO , NO ,    TITLE,    YOUTUBE_URL,    THUMBNAIL_URL
)VALUES(SEQ_CM.NEXTVAL, 4, '[PLAVE BIRTHDAY GIFT] 밤비 - 혼자가 아닌 나','https://www.youtube.com/watch?v=pGkZNlFBiw4', 'https://i.ytimg.com/vi/pGkZNlFBiw4/default.jpg');

INSERT INTO COVER_MUSIC
    (COVER_NO ,NO ,    TITLE,    YOUTUBE_URL,    THUMBNAIL_URL
)VALUES(SEQ_CM.NEXTVAL, 1, '[2024 PLAVE BIRTHDAY GIFT] 노아, 밤비 - Dangerously (원곡 : Charlie Puth)' , 'https://www.youtube.com/watch?v=NFr8WLzLDJk', 'https://i.ytimg.com/vi/NFr8WLzLDJk/default.jpg');

INSERT INTO COVER_MUSIC
    (COVER_NO ,NO ,    TITLE,    YOUTUBE_URL,    THUMBNAIL_URL
)VALUES(SEQ_CM.NEXTVAL, 3, '[From. PLAVE] 노아 ,하민 - Love me or Leave me (원곡 : DAY6)','https://www.youtube.com/watch?v=u1Wp2coFDB4', 'https://i.ytimg.com/vi/u1Wp2coFDB4/default.jpg');

INSERT INTO COVER_MUSIC
    (COVER_NO ,NO ,    TITLE,    YOUTUBE_URL,    THUMBNAIL_URL
)VALUES(SEQ_CM.NEXTVAL, 1, '[COVER] 노아 - ベテルギウス (Betelgeuse) (원곡 : 優里 (Yuuri))','https://www.youtube.com/watch?v=jDQ4-C4AHmA', 'https://i.ytimg.com/vi/jDQ4-C4AHmA/default.jpg');

INSERT INTO COVER_MUSIC
    (COVER_NO ,NO ,    TITLE,    YOUTUBE_URL,    THUMBNAIL_URL
)VALUES(SEQ_CM.NEXTVAL, 1, '[From. PLAVE] 예준 - yours (원곡 : Damons year)','https://www.youtube.com/watch?v=iv9rmTEaECw', 'https://i.ytimg.com/vi/iv9rmTEaECw/default.jpg');

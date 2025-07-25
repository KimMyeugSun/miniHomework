package com.kh.miniHomework.plave;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaveService {

    private final PlaveMapper mapper;

    public int insertMusic(CoverMusicVo vo) {
        return mapper.insertMusic(vo);
    }

    public List<CoverMusicVo> selectMusicList() {
        return mapper.selectMusicList();
    }

    public CoverMusicVo selectMusicOne(String no) {
        PlaveVo plaveVo = mapper.selectPlaveOne(no);
        int pno = plaveVo.getNo();
        return mapper.selectMusicOne(pno);
    }

    public CoverMusicVo modifyMusic(CoverMusicVo vo) {
        return mapper.modifyMusic(vo);
    }

    public int delectMusic(CoverMusicVo vo) {
        return mapper.delectMusic(vo);
    }
}

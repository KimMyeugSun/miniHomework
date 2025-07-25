package com.kh.miniHomework.plave;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/plave")
@CrossOrigin(value = "http://192.168.200.30:5500")
public class PlaveApiController {

    private final PlaveService service;

    @PostMapping
    public ResponseEntity<Object> insertMusic(@RequestBody CoverMusicVo vo){
        service.insertMusic(vo);
        return ResponseEntity.status(200).build();
    }
    @GetMapping
    public ResponseEntity<List<CoverMusicVo>> selectMusicList(){
        List<CoverMusicVo> voList = service.selectMusicList();
        return ResponseEntity.status(200).body(voList);
    }
    @GetMapping("{no}")
    public ResponseEntity<CoverMusicVo> selectMusicOne(@RequestParam String no){
        CoverMusicVo vo = service.selectMusicOne(no);
        return ResponseEntity.status(200).body(vo);
    }
    @PutMapping
    public ResponseEntity<Object> modifyMusic(@RequestBody CoverMusicVo vo){
        service.modifyMusic(vo);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping
    public ResponseEntity<Object> delectMusic(@RequestBody CoverMusicVo vo){
        service.delectMusic(vo);
        return ResponseEntity.status(200).build();
    }
}

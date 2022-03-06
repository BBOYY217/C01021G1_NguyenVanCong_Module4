package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Long id;
    private String name;
    private String singer;
    private String songType;
    private MultipartFile songPath;

    public MusicForm() {
    }

    public MusicForm(String name, String singer, String songType, MultipartFile songPath) {
        this.name = name;
        this.singer = singer;
        this.songType = songType;
        this.songPath = songPath;
    }

    public MusicForm(Long id, String name, String singer, String songType, MultipartFile songPath) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.songType = songType;
        this.songPath = songPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public MultipartFile getSongPath() {
        return songPath;
    }

    public void setSongPath(MultipartFile songPath) {
        this.songPath = songPath;
    }
}

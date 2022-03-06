package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;
    private String songType;
    private String songPath;

    public Music() {
    }

    public Music(String name, String singer, String songType, String songPath) {
        this.name = name;
        this.singer = singer;
        this.songType = songType;
        this.songPath = songPath;
    }

    public Music(Long id, String name, String singer, String songType, String songPath) {
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

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}

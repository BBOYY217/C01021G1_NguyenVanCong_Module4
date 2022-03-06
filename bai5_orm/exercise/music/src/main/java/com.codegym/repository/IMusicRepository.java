package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void save(Music music);
    Music findById(Long id);
    void update(Music music);
    void remove(Long id);
}

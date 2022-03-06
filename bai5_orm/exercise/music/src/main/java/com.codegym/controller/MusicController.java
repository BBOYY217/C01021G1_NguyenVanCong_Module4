package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    private IMusicService musicService = new MusicService();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Music> musicList = musicService.findAll();
        modelAndView.addObject("musicList", musicList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new MusicForm());
        modelAndView.addObject("typeOfMusicArray",
                new String[] {"Nhạc rock", "Nhạc R&B", "Nhạc Rap"});
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getSongPath();
        String fileName = multipartFile.getOriginalFilename();
        String[] array = fileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("ogg") || array[1].equals("m4p")) {
            try {
                FileCopyUtils.copy(musicForm.getSongPath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Music music = new Music(musicForm.getName(), musicForm.getSinger(), musicForm.getSongType(), fileName);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Create successful");
        } else {
            redirectAttributes.addFlashAttribute("message", "Create error");
        }
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("musicForm", musicService.findById(id));
        modelAndView.addObject("typeOfMusicArray",
                new String[] {"Nhạc rock", "Nhạc R&B", "Nhạc Rap"});
        return modelAndView;
    }

    @PostMapping ("/update")
    public String update (MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getSongPath();
        String fileName = multipartFile.getOriginalFilename();
        String[] array = fileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("ogg") || array[1].equals("m4p")) {
            try {
                FileCopyUtils.copy(musicForm.getSongPath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Music music = new Music(musicForm.getId(), musicForm.getName(), musicForm.getSinger(),
                    musicForm.getSongType(), fileName);
            musicService.update(music);
            redirectAttributes.addFlashAttribute("message", "Update successful");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update error");
        }
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("music", musicService.findById(id));
        return modelAndView;
    }

    @PostMapping ("/delete")
    public String delete (Music music, RedirectAttributes redirectAttributes) {
        musicService.remove(music.getId());
        redirectAttributes.addFlashAttribute("message", "Delete successful");
        return "redirect:/music";
    }
}

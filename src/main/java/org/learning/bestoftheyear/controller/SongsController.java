package org.learning.bestoftheyear.controller;

import org.learning.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {
    @GetMapping
    public String List(Model model) {
        model.addAttribute("songList", getSongs());
        return "/songs/songlist";
    }

    @GetMapping("/details/{id}")
    public String detail(@PathVariable(name ="id") int songId, Model model){
    Song song = getSongById(songId);
    model.addAttribute("songId",songId);
    model.addAttribute("song", song);
    return "/songs/songDetail";
    }
    private List<Song> getSongs() {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(1,"Infinity","Guru Josh Project"));
        songList.add(new Song(2,"Stereo Love","Edward Maya & Vika Jigulina"));
        songList.add(new Song(3,"Fly","Inna"));
        return songList;
    }
    private Song getSongById(int id) {
        List<Song> songList = getSongs();
        for (Song song : songList) {
            if(song.getId() == id){
                return song;
            }
        }
        return null;
    }
}

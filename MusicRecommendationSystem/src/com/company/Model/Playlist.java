package com.company.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    @Getter
    String playlistName;

    List<Song> songList;

    public Playlist() {
        this.songList = new ArrayList<>();
    }
}

package com.company.Dao;

import com.company.Model.Song;
import com.company.Model.User;

import java.util.List;

public interface UserDatabaseInterface {

    public void addNewUser(User user);

    public void createPlaylist(String name, String playlist, List<Song> songList);

    public void addSongToPlaylist(String name, String playlist, Song song);

    public void showPlaylist(String name, String playlist);
}

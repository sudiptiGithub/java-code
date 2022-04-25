package com.company.Service;

import com.company.Dao.SongDatabase;
import com.company.Dao.UserDatabase;
import com.company.Model.Song;
import com.company.Model.User;

import java.util.ArrayList;
import java.util.List;

public class SystemService {

    UserDatabase userDatabase = UserDatabase.getInstance();

    SongDatabase songDatabase = SongDatabase.getInstance();

    public void add_song(String name,String singer,String genre,int tempo){
        songDatabase.addSong(new Song(name,genre,tempo,singer));
    }

    public void add_user(String name){
        userDatabase.addNewUser(new User(name));
    }

    public void create_playlist(String name, String playlistName, List<String> songList){
        List<Song> songListOfSongs = new ArrayList<>();
        for (String song:
             songList) {
            songListOfSongs.add(songDatabase.getSong(song));
        }
        userDatabase.createPlaylist(name,playlistName,songListOfSongs);
    }

    public void add_song_to_playlist(String name, String playlistName, String song){
        userDatabase.addSongToPlaylist(name,playlistName,songDatabase.getSong(song));
    }

    public void show_playlist(String name, String playlistName){
        userDatabase.showPlaylist(name,playlistName);
    }

}

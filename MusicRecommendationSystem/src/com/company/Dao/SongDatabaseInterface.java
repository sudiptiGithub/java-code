package com.company.Dao;

import com.company.Model.Song;

import java.util.List;

public interface SongDatabaseInterface {

    public void addSong(Song song);

    public Song getSong(String song);

    public List<Song> getSongMatchingAllDetails(String singer, String genre, int tempo);

    public List<Song> getSongMatchingSingerAndGenre(String singer, String genre);

    public List<Song> getSongMatchingSingerAndTempo(String singer, int tempo);

    public List<Song> getSongMatchingGenreAndTempo(String genre, int tempo);

    public List<Song> getSongMatchingGenre(String genre);

    public List<Song> getSongMatchingTempo(int tempo);

    public List<Song> getSongMatchingSinger(String singer);
}

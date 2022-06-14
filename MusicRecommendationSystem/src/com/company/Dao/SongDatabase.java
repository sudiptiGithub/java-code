package com.company.Dao;

import com.company.Exception.SongAlreadyExistsException;
import com.company.Model.Song;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SongDatabase implements SongDatabaseInterface {

    HashMap<String,Song> songHashMap = new HashMap<>();

    private SongDatabase(){

    }

    private static SongDatabase INSTANCE =null;

    public static SongDatabase getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SongDatabase();
        }
        return INSTANCE;
    }

    @Override
    public void addSong(Song song) {
        if(!songHashMap.containsKey(song.getName())){
            songHashMap.put(song.getName(),song);
        }
        else{
            throw new SongAlreadyExistsException(song.getName()+" already exists. Add a new song");
        }
    }

    @Override
    public Song getSong(String song) {
        return songHashMap.get(song);
    }

    @Override
    public List<Song> getSongMatchingAllDetails(String singer, String genre, int tempo) {

       return songHashMap.values().stream().filter(x -> x.getGenre().equals(genre) && x.getSinger().equals(singer) && x.getTempo()==tempo).collect(Collectors.toList());

    }

    @Override
    public List<Song> getSongMatchingSingerAndGenre(String singer, String genre) {
        return songHashMap.values().stream().filter(x -> x.getGenre().equals(genre) && x.getSinger().equals(singer)).collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongMatchingSingerAndTempo(String singer, int tempo) {
        return songHashMap.values().stream().filter(x ->  x.getSinger().equals(singer) && x.getTempo()==tempo).collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongMatchingGenreAndTempo(String genre, int tempo) {
        return songHashMap.values().stream().filter(x -> x.getGenre().equals(genre) && x.getTempo()==tempo).collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongMatchingGenre(String genre) {
        return songHashMap.values().stream().filter(x -> x.getGenre().equals(genre)).collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongMatchingTempo(int tempo) {
        return songHashMap.values().stream().filter(x -> x.getTempo()==tempo).collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongMatchingSinger(String singer) {
        return songHashMap.values().stream().filter(x -> x.getSinger().equals(singer)).collect(Collectors.toList());
    }
}

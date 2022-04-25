package com.company.Dao;

import com.company.Exception.UserAlreadyExistException;
import com.company.Model.Song;
import com.company.Model.User;

import java.util.*;
import java.util.stream.Stream;

public class UserDatabase implements UserDatabaseInterface {

    HashMap<String, User> userHashMap = new HashMap<>();

    private UserDatabase(){

    }

    private static UserDatabase INSTANCE =null;

    public static UserDatabase getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserDatabase();
        }
        return INSTANCE;
    }

    @Override
    public void addNewUser(User user) {
        if(!userHashMap.containsKey(user.getName())){
            userHashMap.put(user.getName(),user);
        }
        else {
            throw new UserAlreadyExistException("User "+user.getName()+ "already exists" );
        }
    }

    @Override
    public void createPlaylist(String name, String playlist, List<Song> songList) {
        if(userExists(name)){
            userHashMap.get(name).getPlaylistHashMap().put(playlist,songList);
            System.out.println("Playlist added to "+name);
        }
    }

    @Override
    public void addSongToPlaylist(String name, String playlist, Song song) {
        if(userExists(name)){
            userHashMap.get(name).getPlaylistHashMap().get(playlist).add(song);
            System.out.println("Song:"+song.getName()+"  added to Playlist of "+name);
        }
    }

    @Override
    public void showPlaylist(String name, String playlist) {
        if(userExists(name)){
            System.out.println("Playlist:"+playlist);
            for (Song song:
                 userHashMap.get(name).getPlaylistHashMap().get(playlist)) {
                System.out.println(song.getName());
            }
        }
    }

    private boolean userExists(String name){
        if(userHashMap.containsKey(name))
            return true;
        return false;
    }
}

package com.company;

import com.company.Service.SystemService;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SystemService systemService = new SystemService();

        systemService.add_song("song1","AB","Folk",60);
        systemService.add_song("song2","DEF","Rock",70);
        systemService.add_song("song3","AB","Country",55);
        systemService.add_song("song4","XYZ","Rock",60);
        systemService.add_song("song5","XYZ","Rock",75);
        systemService.add_song("song6","AB","Country",60);
        systemService.add_song("song7","DEF","Indie",55);


        systemService.add_song("song8", "AB", "Folk", 60);
        systemService.add_user ("user1");
        systemService.create_playlist ( "user1","playlist1",new ArrayList<String>(Arrays.asList("song1","song2","song3")));
        systemService.add_song_to_playlist ("user1","playlist1", "song7");
        systemService.show_playlist ("user1", "playlist1" );





    }
}

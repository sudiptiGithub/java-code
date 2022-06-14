Music Recommendation system

Problem Definition:
Create an online music recommendation system which suggests songs according to user taste.

Features:
Application has two major things :
The songs, which are catalogued in the app’s data store. Songs can be described by attributes such as genre, tempo, singer.
The people : Each person has a playlist of songs that they can choose to play from.

Design a system that recommends a set of songs from our music library to the user based on his preferences (matching genre / singer/ tempo) taking into account his current playlist.  
Pick a song based on the following order:
One which matches with maximum matching attributes.
When only one attribute is matching, pick one in the following order : genre > singer > tempo.
To decide priority between two genres\singer\tempo, consider the number of songs in each category in user’s playlist to decide which song gets more priority. One with higher number of songs gets high priority. If number of songs are same, show in any order.
Show the recommended songs in a sorted order(Most matched one first, least matched in the last)

Requirements:
Add a new song to data store.
Add a new user to the system.
Create a playlist for the user (Assume single playlist for simplicity)
Add songs to the user’s playlist
Display user’s playlist
Recommend songs based on user preferences

Bonus question:
Extend the system to let users add friends.
add_friend(“user”, “friend1”)
Recommend songs based on the user and his friends playlist.




Other Details:
Do not use any database or NoSQL store, use in-memory store for now.
Do not create any UI for the application.
Code should be demo able. Write a driver class for demo purpose, which will execute all the commands at one place in the code and test cases.
Code should be extensible. Wherever applicable, use interfaces and contracts between different methods
Work on the expected output first and then add good-to-have features of your own.




Test Cases:
(Test cases are defined for understanding feature requirements only. Please model it appropriately based on your service implementation)

Assuming following songs exist in appstore

Song1 {name:“song1”, singer:“AB”, genre:”Folk”, tempo:60}
Song2 {name:“song2”, singer:“DEF”, genre:”Rock”, tempo:70}
Song3 {name:“song3”, singer:“AB”, genre:”Country”, tempo:55}
Song4 {name:“song4”, singer:“XYZ”, genre:”Rock”, tempo:60}
Song5 {name:“song5”, singer:“XYZ”, genre:”Rock”, tempo:75}
Song6 {name:“song6”, singer:“AB”, genre:”Country”, tempo:60}
Song7 {name:“song7”, singer:“DEF”, genre:”Indie”, tempo:55}

Here are the sample test cases to run:

add_song(name:“song8”, singer:“AB”, genre:”Folk”, tempo:60)
add_user (name:“user1”)
create_playlist ( “user1”,  “playlist1”, {“song1”, “song2”, “song3”})
add_song_to_playlist (“playlist1”, “song4”)
show_playlist (“user1”, “playlist1” )
recommend_songs(“user1”)
Song 8 - matching all 3 attributes (singer, genre, tempo - all matching with song1)
Song 5 - matching two attributes (genre ‘Rock’ has 2 songs  in user playlist hence it is given priority)
Song 6 - matching two attributes
Song 7 - Single matching attribute



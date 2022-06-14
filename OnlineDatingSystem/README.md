
Online Dating Application
Problem Definition
We have to create an online dating application which has following functionality.

Users will have details, like
Location
Interests/Hobbies
Age
Gender
The application should show users their potential matches in an order of relevance. Relevance will be in this order:
Gender : Opposite gender to be given higher priority.
Interests: More the common interests, more is the priority.
Proximity: Nearer matches should be given more priority. Use euclidean distance for computing distance between 2 locations.
Users can then like/ignore matches.
In case someone is liked, the data should be stored for further processing.
Finally all the matches(case where 2 users have liked each other) in the system should be shown.

Sample User Data
(Take this as command line input/ file input/ hardcoded in main function/ through test cases.)

User1 				(Name of user)
2,3  				(Location Coordinates, comma separated)
Eating,drinking,sleeping 	(Comma Separated Interests)
23 				(Age)
Male 				(Gender)

User2
3,4
Coding,Hacking,Breaking
45
Female

User3
4,6
Coding,drinking,reading
32
Female

Output Console
Lines in Italic show the system output and lines in bold show the user input.

Enter User or Show Matches?
Enter User
User1
Option 1 : User3
Like?
No
Option 2 : User 2
Like?
Yes
Enter User or Show Matches?
Enter User
User2
Option 1 : User1
Like?
Yes
Option 2 : User3
Like?
No
Enter User or Show Matches?
Show Matches
User1 and User2 have matched
Expectations
Code should be demoable. Either by using a main driver program on command line or via test cases.
Code should cover all the edge cases possible and work for them. If it is not possible to handle some case, it should fail gracefully.
Code should be readable and modular.
Guidelines
Time Duration : 90 mins
Use of database is not allowed, store all data in-memory.
Please discuss any doubts you have with an interviewer.
You are free to use the language of your choice.
All work should be your own.
Appendix
According to the Euclidean distance formula, the distance between two points in the plane with coordinates (x, y) and (a, b) is given by: dist((x, y), (a, b)) = sqrt((x - a)² + (y - b)²)

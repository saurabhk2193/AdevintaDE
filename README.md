# Adevinta Take home test
***
Created a Scala program to read all text files from given directory which is passed as parameter.
Then percentage of match between command prompt input and text file data is done.

###Build:
This is built using sbt config for running and testing application.


###How to use:
Open the application in IntelliJ or any IDE and pass directory path as input which is 
_src/main/scala/dir1/dir2_ in our case.

Then input string is asked at prompt 

_search>_

If no match is found the "_no match found_" pops up.

To quit the application type "_:quit_" at the prompt


##Note:
1. Special characters are removed from the words. Word constitutes of only alphanumeric.
2. Two words are considered equal if they are same after removing special characters (Irrespective of the case).

Please feel free to contact me for queries.

Saurabh
(saurabh544@gmail.com)
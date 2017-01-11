CS542 Design Patterns
Fall 2016
Assignment 5 README FILE

Due Date: Thursday, December 15, 2016
Submission Date: Thursday, December 15, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author: Purva M. Myakal
e-mail: pmyakal1@binghamton.edu


PURPOSE:
In this assignment, we learnt how to use java reflection correctly. 


DATA STRUCTURE USED:
I used HashMap to save First objects, Second objects and data types. 

LOGIC:
We are given one Input File containing objects' data to be restored, of type First.java and Second.java.
Using that data, populate the Data Structure with the objects and after successfully populating, count the 
number of unique and total number of objects of First.java and Second.java.

PERCENT COMPLETE:
To my knowlegde, the assignment is complete.

PARTS THAT ARE NOT COMPLETE:
None.

BUGS:
None.

FILES:
 ---genericDeser
     	   ----------driver
	        	   ----------Driver.java [has driver.main()]
           ----------util
	              ----------First.java	[Class whose objects are populated.]
	              ----------Second.java	[Class whose objects are populated.]
	              ----------PopulateObjects.java [has java code.]
           ----------fileOperations
	              ----------FileProcessor.java [has file operations]
           ----------logger
                  ----------Logger.java [has logger and debug operations]

SAMPLE OUTPUT:
Number of unique First objects: 4952
Total Number of First objects: 4952
Number of unique Second objects: 5018
Total Number of Second objects: 5048


TO COMPILE:
>ant -buildfile build.xml all

TO RUN:
>ant -buildfile build.xml run -Darg0=[input_file] -Darg1=[DEBUG_VALUE]

EXTRA CREDIT:
None.

BIBLIOGRAPHY:
None.

ACKNOWLEDGEMENT:
None.
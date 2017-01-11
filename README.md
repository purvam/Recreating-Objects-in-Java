# Recreating-Objects-in-Java

Developed to recreate given types of objects from an input file and count unique and total no. of objects, implemented java reflection.

One Input File is given, containing objects' data to be restored. These data are of type First.java and Second.java. Using that data, the HashMaps are populated with the objects. To recreate these objects, without directly using constructors, java reflection is used.

Sample Input:
fqn:genericDeser.util.First
type=String, var=StringValue, value=abcaa
type=float, var=FloatValue, value=34.47
type=int, var=IntValue, value=49
type=short, var=ShortValue, value=26
fqn:genericDeser.util.Second
type=double, var=DoubleValue, value=14.87
type=int, var=IntValue, value=48
type=boolean, var=BooleanValue, value=true


fqn gives the fully qualified name of the class, whose object is to be created. type gives the instance variable type and the value is used to initialize that variable to given value. var is used to call to setter functions easily.

After successfully populating, count the number of unique and total number of objects of First.java and Second.java.

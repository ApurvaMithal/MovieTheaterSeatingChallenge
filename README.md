Apurva Mithal
Movie Theatre Seating Challenge

READ ME
	- Language used: Java
	- JDK Version: 1.8.0_144

ASSUMPTIONS
	- For each request, the number of seats requested is always less than or equal to the capacity of one row of the theater (20).
	- Total number of requested seats from all the requests is always less than or equal to the capacity of the movie theater (10*20).
	- The top most priority for the audience is that each member of the group sits together i.e. on the same row. In case when this is not 	  	possible, only then they agree to split in different rows.
	- Audience prefer seats in the front row more than the seats in the back row i.e. the order of preference of rows is:
		o Row# 1 > Row# 2 > Row# 3 > Row# 4> Row# 5 > Row# 6 > Row# 7 > Row# 8 > Row# 9 > Row# 10
	- The requests are processed in the same order as which they have arrived i.e. on first come first serve basis.
	- Input and Output file are text file with extension “.txt”
	- Input file is a valid file with requests in the following format 
		o reservation identifier, followed by a space, and then the number of seats requested


Note:
	- While running the file you will need to provide two command line arguments:
		o Absolute path of the input file where the input file is placed.
		o Absolute path of the output file where you want the result to be generated.
	- There are 3 java files:
		o Main.java - This is the main file
		o FileManager.java – This has modules performing reading input from the input file and writing output to the output file.
		o MovieTheater.java – This contains the main logic behind seat reservation. 

HOW TO RUN
	- Open the command prompt. 
	- Change the directory to the path where java files are present.
	- Compile the java file Main.java by the following command -
		o javac Main.java
	- Run Main.java by giving the following commands:
		o java main <absolute path of input file> < absolute path of output file>
		o For example: 
			 java Main D:\Walmart\eclipse\Input.txt D:\Walmart\eclipse\Output.txt
	- Output file is generated in the path specified in the command line argument.




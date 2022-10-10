# Lloseng

This repository contains a copy of [the cody required to complete the first assignment](https://github.com/TimLethbridge/Lloseng)
using the book [Object-Oriented Software Engineering: Practical Software
Development using UML and Java](http://www.site.uottawa.ca/school/research/lloseng/), 2nd Edition, 2004 McGraw Hill.
by [Timothy C. Lethbridge](http://www.eecs.uottawa.ca/~tcl) and
[Robert Laganière](http://www.eecs.uottawa.ca/~laganier).

# Assignment 1 - 5% of the final grade (started during lab 2) 

Assignment Submission before October 9th, 11h30pm using [BrightSpace](https://uottawa.brightspace.com/)

During the lab 2, you will start working on your assignment 1. The TA will explain how to setup your environment, how to measure the execution time of a Java program and HOW TO DEBUG!

**INSTRUCTIONS**

* You need to create a Group in Brightspace (Groups_Assignment1).

**Group work and partners**: In this lab, and all other labs that involve programming, you
will work in **groups of two**.  
**No groups of 3 will be permitted.**

## Format

Your **private** repository should be named \[prefix\]-\[student-number-1\]_\[student-number-2\], for example


```
assignment1-1484511_90210901210
```

When finished, submit the following text via the Brightspace submission link: 

* Your names and students numbers
* A link to your GitHub repository.

Your GitHub repository should contain all solutions to the Assignment 1,
no solution submissions via BrightSpace will be evaluated. 
Only the information above should be submitted to BrightSpace.
Submissions by email will NOT be accepted.

## Logistics

#### Using Eclipse

Eclipse will be presented in this lab. However, feel free to use your preferred IDE.
Instruction on how to setup your environment will be presented during the beginning of lab 2. Material is available on BS (under lab 2).

#### Exercises

Work on the following exercises from the textbook. You must hand in
only one copy of answers per group. Make sure the names and student numbers
of both partners are clearly indicated. You must work on these questions
during the lab and then finish off the work on your own time before the deadline.

## Analysis of various design alternatives

1. Before coming to the lab, you are asked to read and understand Section 2.9 of
the textbook, starting on page 57. If you have not done this, take five
minutes now to do it. The texbook pages necessary to complete this assignment can be found in the Brightspace.

2. This Lab/Assignment will focus on [PointCP](/pointcp) from this repository,
so all instructions will be relative to that directory.

```
cd pointcp
```

Before making any changes, compile the code and make sure it runs.

```
javac PointCP.java PointCPTest.java
```

To run the program

```
java PointCPTest
```
You can, of course, run the programs using the Eclipse IDE (or your preferred IDE).

## PointCP

All modifications should be done within the `/pointcp` directory.
By modifying the original version (Design 1), implement the following designs.

* design 2 (add code in `/design2` directory). Add your code in  `PointCP2.java`. 
* design 3 (add code in `/design3` directory). Add your code in  `PointCP3.java` . 
* design 5 (add code in `/design5` directory). Add your code in  `PointCP5.java` and modify your existing  `PointCP2.java` and  `PointCP3.java` (to adapt them to the new design requirements. 

4. Modify the `PointCPTest` class to allow you to test the designs you
have developed. Do a thorough series of tests to ensure your classes work properly. You can implement other classes to facilitate the task or add any extar functions to the `PointCPTest` class. 

5. Hand in your answers to exercises E26 (table of what you think will be the advantages and
disadvantages of each design), and E28-E30 (performance analysis, comparing all three
designs you have implemented instead of Design 1 with Design 5 as the book says). To do
this evaluation, for each design create random instances and then call each method many
thousands of times, and then find the elapsed time in milliseconds for the fixed number
of iterations. Make sure that your program runs each time for about 10 seconds so you
get a good measure of performance. Test each method separately. Run each version
several times to ensure that your results are consistent and use the median result as your
definitive result, plus give the maximum and minimum execution time.

6. Hand in a description of how you did the tests, sample outputs from running the tests,
the table and a discussion of the results.


| Design | How cartesian coordinates are computed | How polar coordinates are computed |
| --- | --- | --- |
| Design 2: Store polar coordinates only | Computed on demand, but not stored| Simply returned |
| Design 3: Store cartesian coordinates only | Simply returned | Computed on demand, but not stored |
| Design 5: Abstract class with designs 2 and 3 as subclasses| Depends on the concrete class used | Depends on the concrete class used |

All your written answers can be submitted in a single Word or PDF document. Make sure to push this document into your repository.

## PART 2 - Object Oriented Review

Based on the memory diagram below, write the implementation in Java of all the
classes, instance variables, and constructors. Submit the Java classes including a class named *Test.java* containing a **main** method (that is used to create the necessary instances and initialize all variables). Place your code in the folder *code_part2* of your repository.

![alt text](https://github.com/SEG2105-uottawa/SEG2105-Assignment1/blob/master/seg2105-a1.png)


**If you have questions related to this assignment, please use the Piazza forums (tag assignment1)!**

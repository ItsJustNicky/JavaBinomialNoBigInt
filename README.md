# Etude6 - Counting it up
Nicky Patterson, Daniel Prvanov

## Start Up

The project uses java.util.* to help the user input the data and the program to process the data. java.util.ArrayList is also imported to allow ArrayLists to accessed and used to store data for manipulation.

```
The program can be run and compiled from any java friendly IDE
```
The user is able to pass input values into the System input and it will give the result of the binomial equation 
!n/!k*!(n-k), it does so without the use of big Int and is able to take inputs that would result in max long as an output

## How The Program Works
The program works using by simplifying N by first converting N into an array list of the numbers that makeup N factorial, it then removes the common numbers from here and the larger of the two between k! and n-k!, it then simplifies the remaining numbers within N! and the smaller of k! or n-k!, this is done by dividing the two first by the numbers in the smaller fact group, and then again 9 times by simiplifying both groups by numbers 10 through 2, it then multiplies the remaining numbers left in the array lists, and if the lesser of the two group has any non 1 numbers left it divides N! by the lesser fact


## Testing

To test the data we used various numbers that grow exponeniantly in size up that result in various outputs up to max longs, some test data would have large factorials prior to simplifcication on both sides, while some would just have N having a large factorial much over max long, this is done in order to make sure it can handle all types of values that have a result equal to or less than max long.

# Counting it up
# @author Nicky Patterson, Daniel Pravanov
# @desc A class used to calculate binomial   # equations using Longs as the largest 
# interger size declaration

# numbersGoIn
# @input A string variable gotten from 
# system.in
# A method used to do the computing of the result of N!/K!(N-K)!

# nFact
# @in the Long n passed from system.In after 
# conversion from string to long
# A method that creates an array list consisting of the factors of N

# otherFact
# @in the the smaller of either K or N-K passed from system.In after 
# conversion from string to long
# A method that creates an array list consisting of the factors of either K or N-K

# furtherReduce
# @ in arrayList N, and arrayList other, array lists of factorials gotten from N and K
# A method that divides N and K by K, to simplify numbers within the arrayList

# reduceX
# @ in arrayList N, and arrayList other, array lists of factorials gotten from N and K, N being the number you wish to simplify the two array lists by
# A method that divides N and K by N, to simplify numbers within the arrayList

# multiply
# @ in an array list you wish to multiply
# multiplies each number in the array by the next number
# @return out total multiplied array list
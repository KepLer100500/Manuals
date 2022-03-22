# Go dutch

The purpose of this exercise is to familiarize you with basic conditional and cyclic operations.

Estimated workload of this exercise is _20 minutes_.

### Description

Consider a company of friends visiting a restaurant.
They decided to equally split the bill.

Friends decided to add 10 percent of the bill total amount as tips.
Then they cover the total payment in equal parts.

Please, proceed to [GoDutch](./src/main/java/com/epam/rd/autotasks/godutch/GoDutch.java) class
and write a program that reads a bill total amount and a number of friends, and then prints part to pay.

Consider some details:
- Program must read data from System.in
- Bill total amount cannot be negative. If input value is negative, the program stops, printing: `Bill total amount cannot be negative`
- Number of friends cannot be negative or zero. If input value is, then the program stops, printing: `Number of friends cannot be negative or zero`
- Bill total amount, number of friends and part to pay are integers

### Example

Input:
```
1000  
5
```
Output:
```
220
```

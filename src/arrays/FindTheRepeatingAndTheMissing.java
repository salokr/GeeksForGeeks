/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
/*
Given an unsorted array of size n. 
Array elements are in range from 1 to n. 
One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.

Examples:

  arr[] = {3, 1, 3}
  Output: 2, 3   // 2 is missing and 3 occurs twice 

  arr[] = {4, 3, 6, 2, 1, 1}
  Output: 1, 5  // 5 is missing and 1 occurs twice 
*/
public class FindTheRepeatingAndTheMissing 
{
    public static void byHashing(int a[])
    {
        int sum=0,repeat=-1;
        HashSet<Integer> set=new HashSet<>();
        for(int i:a)
        {
            sum+=i;
            if(set.contains(i))
                repeat=i;
            else set.add(i);
        }
        //System.out.println("repeated is "+repeat);
        //System.out.println("missing is "+(repeat+(a.length*(a.length+1)/2)-(sum)));
        System.out.println(repeat+" "+(repeat+(a.length*(a.length+1)/2)-(sum)));
    }
    public static void main(String[] args)
    {
        int arr[] = {4, 3, 6, 2, 1, 1};
        byHashing(arr);
    }
}
/*          better approaches
Method 2 (Use count array)
1) Create a temp array temp[] of size n with all initial values as 0.
2) Traverse the input array arr[], and do following for each arr[i]
……a) if(temp[arr[i]] == 0) temp[arr[i]] = 1;
……b) if(temp[arr[i]] == 1) output “arr[i]” //repeating
3) Traverse temp[] and output the array element having value as 0 (This is the missing element)

Time Complexity: O(n)
Auxiliary Space: O(n)

Method 3 (Use elements as Index and mark the visited places)
Traverse the array. While traversing, use absolute value of every element as index and make the value at this index as negative to mark it visited. If something is already marked negative then this is the repeating element. To find missing, traverse the array again and look for a positive value.

#include<stdio.h>
#include<stdlib.h>
 
void printTwoElements(int arr[], int size)
{
    int i;
    printf("\n The repeating element is");
 
    for(i = 0; i < size; i++)
    {
        if(arr[abs(arr[i])-1] > 0)
            arr[abs(arr[i])-1] = -arr[abs(arr[i])-1];
        else
            printf(" %d ", abs(arr[i]));
    }
 
    printf("\nand the missing element is ");
    for(i=0; i<size; i++)
    {
        if(arr[i]>0)
            printf("%d",i+1);
    }
}
 
/* Driver program to test above function 
int main()
{
    int arr[] = {7, 3, 4, 5, 5, 6, 2};
    int  n = sizeof(arr)/sizeof(arr[0]);
    printTwoElements(arr, n);
    return 0;
}
Run on IDE
Time Complexity: O(n)

Thanks to Manish Mishra for suggesting this method.

Method 4 (Make two equations)
Let x be the missing and y be the repeating element.

1) Get sum of all numbers.
Sum of array computed S = n(n+1)/2 – x + y
2) Get product of all numbers.
Product of array computed P = 1*2*3*…*n * y / x
3) The above two steps give us two equations, we can solve the equations and get the values of x and y.

Time Complexity: O(n)

Thanks to disappearedng for suggesting this solution.

This method can cause arithmetic overflow as we calculate product and sum of all array elements. See this for changes suggested by john to reduce the chances of overflow.
*/
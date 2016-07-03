/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author ashutosh
 */
/*
Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.

Example

Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3} 
In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.

The problem is very similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of 
famous Dutch national flag problem.
*/
/*
WILL BE USING ALGORITHM SIMILAR TO PARTITION ALGO OF QUICK_SORT USING %2 FOR PIVOTING
*/
public class SegregateEvenAndOddNumbers 
{
    public static void doSwap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void segregateOddEven(int a[])
    {
        int left=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==0)
            {
                doSwap(a, i, left);
                left++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a[]={12, 34, 45, 9, 8, 90, 3};
        segregateOddEven(a);
    }
}

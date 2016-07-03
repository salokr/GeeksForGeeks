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
Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
The functions should put all 0s first, then all 1s and all 2s in last.

Example
Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

THE PROBLEM CAN BE SOLVED SIMPLY WITH COUNTING NUMBER OF 0's 1's AND 2's BUT AN INTERESTING ALGO IS DISCUSSED IN POST AND IMPLEMENTED HERE

The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:
a[1..Lo-1] zeroes (red)
a[Lo..Mid-] ones (white)
a[Mid..Hi] unknown
a[Hi+1..N] twos (blue)
The unknown region is shrunk while maintaining these conditions

Lo := 1; Mid := 1; Hi := N;
while Mid <= Hi do
Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
case a[Mid] in
0: swap a[Lo] and a[Mid]; Lo++; Mid++
1: Mid++
2: swap a[Mid] and a[Hi]; Hi–
*/

public class SortAnArrayOf0s1sAnd2s 
{
    public static void swap(int a[],int i1,int i2)
    {
        int temp=a[i1];
        a[i1]=a[i2];
        a[i2]=temp;
    }
    public static void sortArray(int a[])
    {
        int low=0,mid=0,high=a.length-1;
        while(mid<=high)
        {
            switch(a[mid])
            {
                case 1:
                    mid++;//just move to next element
                    break;
                case 2:
                    swap(a,mid,high);
                    high--;//we donot know what is currently at high so we cant move mid here it is still unknown 
                    break;//remember this is different than case when a[i] is 1
                case 0:
                    swap(a,low,mid);
                    low++;//here we need to move low and mid both
                    mid++;//because we know that before mid all values are composed of either 0 or 1 in sorted form
                    break;//in other way this is not the case when we are dealing with unknown part of array..
            }
        }
       System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a[]= {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};;
        sortArray(a);
    }
}

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
Find whether an array is subset of another array | Added Method 3
Given two arrays: arr1[0..m-1] and arr2[0..n-1]. 
Find whether arr2[] is a subset of arr1[] or not. 
Both the arrays are not in sorted order. 
It may be assumed that elements in both array are distinct.
Examples:
Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]
Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]
Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
Output: arr2[] is not a subset of arr1[]
*/
public class FindWhetherAnArrayIsSubsetOfAnotherArray 
{
    /*Using Merge Technique, checks whether b is subset of a*/
    public static void isSubSet(int a[],int b[])
    {
        Arrays.sort(a);//o(nlogn)
        Arrays.sort(b);//o(mlogm)
        int i=0,j=0,count=0;
        while(i<a.length&&a[i]!=b[0])//o(n)
            i++;
        while(i<a.length&&j<b.length&&a[i++]==b[j++])
            count++;
        if(count!=b.length)
            System.out.println("Nope");
        else
            System.out.println("Subset Found");
    }
    public static void main(String[] args)
    {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};
        isSubSet(arr1, arr2);
    }
/*
    BEST APPROACH HERE WILL BE TO USE HASHING IN TERMS OF TIME COMPLEXITY BECAUSE WE ARE LOOKING FOR SUBSET
*/
}

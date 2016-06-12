/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
/*
Print All Distinct Elements of a given integer array
Given an integer array, print all distinct elements in array. 
The given array may contain duplicates and the output should print every element only once. 
The given array is not sorted.
Examples:
Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
Output: 12, 10, 9, 45, 2

Input: arr[] = {1, 2, 3, 4, 5}
Output: 1, 2, 3, 4, 5

Input: arr[] = {1, 1, 1, 1, 1}
Output: 1
*/

public class PrintAllDistinctElementsOfaGivenIntegerArray 
{
    public static void printDistinct(int a[])
    {
        HashSet<Integer> map=new HashSet<Integer>();
        for(int i=0;i<a.length;i++)
        {
            if(!map.contains(a[i]))
                map.add(a[i]);
        }
        Object[] vals=map.toArray();
        for(Object o:vals)
            System.out.print(o+",");
    }
    public static void main(String[] args)
    {
       int arr[] = {12, 10, 9, 45, 2, 10, 10, 45};
        printDistinct(arr);
    }
}

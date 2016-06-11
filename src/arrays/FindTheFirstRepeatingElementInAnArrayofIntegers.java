/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author ashutosh
 */
/*
Find the first repeating element in an array of integers
Given an array of integers, find the first repeating element in it. We need to find the element that occurs more than once and whose index of first occurrence is smallest.

Examples:

Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
Output: 5 [5 is the first element that repeats]

Input:  arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
Output: 6 [6 is the first element that repeats]
*/
public class FindTheFirstRepeatingElementInAnArrayofIntegers 
{
    public static void findFirstRepeatingPair(int a[])
    {
        HashMap<Integer,Integer> set=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(set.containsKey(a[i]))
            {
                int occurence=set.get(a[i]);
                if(occurence<min)
                    min=occurence;
            }
            set.put(a[i], i);
        }
        if(min!=Integer.MAX_VALUE)
        System.out.println("First Repeated Element Is : "+a[min]);
    }
    public static void main(String[] args)
    {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        findFirstRepeatingPair(arr);
        int arr2[]= {6, 10, 5, 4, 9, 120, 4, 6, 10};
        findFirstRepeatingPair(arr2);
    }
}

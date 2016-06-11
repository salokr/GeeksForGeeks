/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.*;
/**
 *
 * @author ashutosh
 */
/*                                                             Task Description

Count pairs with given sum
Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.

Examples:
Input  :  arr[] = {1, 5, 7, -1}, 
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5}, 
          sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &
                     (1, 5)         

Input  :  arr[] = {1, 1, 1, 1}, 
          sum = 2
Output :  6
There are 3! pairs with sum 2.

Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
                   5, 4, 2, 1, 1, 1}, 
          sum = 11
Output :  9
Expected time complexity O(n)
*/


public class CountPairWithSum 
{
    public static void getCount(int a[],int sum)
    {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            int key=a[i];
            if(!map.containsKey(key))
                map.put(key, 0);
            int frequency=map.get(key);
            map.remove(key);
            map.put(key, frequency+1);
        }
        for(int i=0;i<a.length;i++)
        {
            int current=(a[i]);
            if(map.get(sum-current)!=null)
                count+=map.get(sum-current);
            //System.out.println(count+" "+(sum-current));
            if(sum-current==a[i])
                count--;
            
        }
        System.out.println("Count: "+count/2);
    }
    public static void main(String[] args)
    {
        int arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        getCount(arr, 11);
    }
}

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
Find a pair with the given difference
Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n.

Examples:
Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
Output: Pair Found: (2, 80)

Input: arr[] = {90, 70, 20, 80, 50}, n = 45
Output: No Such Pair
*/
public class FindaPairWithTheGivenDifference 
{
    public static void pairExists(int a[],int k)
    {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            int required=k-a[i];
            if(set.contains(required)||set.contains(-required))
            {
                System.out.println("Found");
                return;
            }
            set.add(a[i]);
        }
        System.out.println("Not Found");
    }
    public static void main(String[] args)
    {
        int arr[] = {5, 20, 3, 2, 50, 80}, n = 78;
        pairExists(arr, n);
        int arr2[] = {90, 70, 20, 80, 50}, n2 = 45;
        pairExists(arr2, n2);
    }
}

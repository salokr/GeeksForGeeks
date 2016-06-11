/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ashutosh
 */

/*                                                                  TASK DESCRIPTION
Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

Example:

Input: arr[] = {3, 1, 4, 6, 5}
Output: True
There is a Pythagorean triplet (3, 4, 5).

Input: arr[] = {10, 4, 6, 12, 5}
Output: False
There is no Pythagorean triplet.
*/

public class PythagoreanTriplet 
{
    HashSet<Integer> set=new HashSet<>();
    public static void findTriplet(int a[])
    {
        for(int i=0;i<a.length;i++)
            a[i]*=a[i];
        Arrays.sort(a);
        for(int i=a.length-1;i>1;i--)
        {
            int currsquare=a[i];
            int left=0,right=i-1;
            while(left<right)
            {
                if(a[left]+a[right]==currsquare)
                {
                    System.out.println("Yes");
                    return;
                }
                else if(a[left]+a[right]<currsquare)
                    left++;
                else right--;
            }
        }
        System.out.println("No");
        
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            findTriplet(a);
            t--;
        }
    }
}

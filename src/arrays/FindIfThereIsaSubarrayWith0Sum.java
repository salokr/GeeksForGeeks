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
Find if there is a subarray with 0 sum
Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.

Examples:

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.
*/
public class FindIfThereIsaSubarrayWith0Sum 
{
    public static void findZeroSum(int a[])
    {
        HashSet<Integer> sumtillnow=new HashSet<>();
        int sum=a[0];
        for(int i=1;i<a.length;i++)
        {
            sumtillnow.add(sum);
            sum+=a[i];
            if(sumtillnow.contains(sum))
            {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("Nope");
    }
    public static void main(String[] args)
    {
        int a[]={4, 2, -3, 1, 6};
        int b[]={4, 2, 0, 1, 6};
        int c[]={-3, 2, 3, 1, 6};
        findZeroSum(a);
        findZeroSum(b);
        findZeroSum(c);
    }
}

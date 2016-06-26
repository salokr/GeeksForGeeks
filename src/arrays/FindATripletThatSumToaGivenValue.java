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
Find a triplet that sum to a given value
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. 
If there is such a triplet present in array, then print the triplet and return true. 
Else return false. For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9) 
present in array whose sum is 24.
*/
public class FindATripletThatSumToaGivenValue 
{
    public static void isTriplet(int a[],int k)
    {
        Arrays.sort(a);
        for(int i=0;i<a.length-2;i++)
        {
            int l=i+1;
            int r=a.length-1;
            while(l<r)
            {
                if(a[i]+a[l]+a[r]==k)
                {
                    System.out.println("Triplets exists : "+a[i]+" "+a[l]+" "+a[r]);
                    return;
                }
                else if(a[i]+a[l]+a[r]<k)
                    l++;
                else r--;
            }
        }
        System.out.println("No Such Triplets");
    }
    public static void main(String[] args)
    {
        int a[]={12, 3, 4, 1, 6, 9};
        isTriplet(a, 24);
        int A[] = {1, 4, 45, 6, 10, 8};
        isTriplet(A, 22);
    }
}

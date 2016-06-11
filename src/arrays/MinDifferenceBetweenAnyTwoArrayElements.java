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
public class MinDifferenceBetweenAnyTwoArrayElements 
{
    public static void findDiff(int a[])
    {
        Arrays.sort(a);
        int mindiff=Integer.MAX_VALUE;
        for(int i=1;i<a.length;i++)
            if(a[i]-a[i-1]<mindiff)
                mindiff=a[i]-a[i-1];
        System.out.println("MinDiff: "+mindiff);
    }
    public static void main(String[] args)
    {
        int a[]={4,5,7,1,4,6,8,0,4,13,5,6,8,8};
        findDiff(a);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author ashutosh
 * 
Check if any two intervals overlap among a given set of intervals
An interval is represented as a combination of start time and end time. Given a set of intervals, check if any two intervals overlap.
Input:  arr[] = {{1,3}, {5,7}, {2,4}, {6,8}}
Output: true
The intervals {1,3} and {2,4} overlap


Input:  arr[] = {{1,3}, {7,9}, {4,6}, {10,13}}
Output: false
No pair of intervals overlap. 
Expected time complexity is O(nLogn) where n is number of intervals.
 */
public class CheckifAnyTwoIntervalsOverlapAmongaGivenSetofIntervals 
{
    public static void checkIntervals(Integer a[][])
    {
        Arrays.sort(a,new Comparator<Integer[]>()
        {
            @Override
            public int compare(Integer[] interval1,Integer[] interval2) 
            {
                return interval1[0]-interval2[0];
            }
        });
        /*for(int i=0;i<a.length;i++)
            System.out.println(a[i][0]+" "+a[i][1]);*/
        for(int i=0;i<a.length-1;i++)
            if(a[i][1]>=a[i+1][0]){
                System.out.println("YES");return;}
        System.out.println("NO");
    }
    public static void main(String[] args)
    {
       Integer arr[][] = {{1,3}, {5,7}, {2,4}, {6,8}};
       Integer arr2[][] = {{1,3}, {7,9}, {4,6}, {10,13}};
        checkIntervals(arr);
        checkIntervals(arr2);
    }
}

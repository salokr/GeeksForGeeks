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
 */


/*
Merge Overlapping Intervals
Given a set of time intervals in any order, merge all overlapping intervals into one and 
output the result which should have only mutually exclusive intervals.
Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. 
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. 
Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
*/

public class MergeOverlappingIntervals 
{
    public static void mergeIntervals(Integer a[][])
    {
        Arrays.sort(a,new Comparator<Integer[]>()
        {
            @Override
            public int compare(Integer[] i1,Integer[] i2 )
            {
                int finishi1=i1[1];
                int starti2=i2[0];
                return finishi1-starti2;
            }
        });
        /*for(int i=0;i<a.length;i++)
            System.out.println(a[i][0]+" "+a[i][1]);*/
        for(int i=0;i<a.length-1;i++)
        {
            int finish1=a[i][1];
            int start2=a[i+1][0];
            if(finish1>=start2)//Merge
            {
                int finish2=a[i+1][1];
                int start1=a[i][0];
                a[i][0]=a[i][1]=-1;
                a[i+1][1]=finish1>finish2?finish1:finish2;
                a[i+1][0]=start1<start2?start1:start2;
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i][0]!=-1)
                System.out.println(a[i][0]+" "+a[i][1]);}
    }
    public static void main(String[] args)
    {
        Integer arr[][]={{1,3}, {2,4}, {5,7}, {6,8} };
        mergeIntervals(arr);
    }
}

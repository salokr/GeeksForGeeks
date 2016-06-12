/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ashutosh
 */
/*
Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. Expected time complexity is O(n) and auxiliary space is O(1).
Example:

Input: 
   arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
Output:
  Index 9
Assuming array index starts from 0, replacing 0 with 1 at index 9 causes
the maximum continuous sequence of 1s.

Input: 
   arr[] =  {1, 1, 1, 1, 0}
Output:
  Index 4
*/
public class FindIndexof0TobeReplacedWith1ToGetLongestContinuousSequenceOf1sInabinaryArray 
{
    public static void findZeroPos(int a[])
    {
        int left[]=new int[a.length];
        int right[]=new int[left.length];
        ArrayList<Integer> zeroesat=new ArrayList<>();
        int onecount=0;
        //count number of 1's to the left of each index
        for(int i=0;i<a.length;i++)
        {
            left[i]=onecount;
            if(a[i]==1)
                onecount++;
            else if(a[i]==0)
            {
                onecount=0;
                zeroesat.add(i);
            }
        }
        //count number of 1's to the right of each index
        onecount=0;
        for(int i=a.length-1;i>=0;i--)
        {
            right[i]=onecount;
            if(a[i]==1)
                onecount++;
            else if(a[i]==0)
                onecount=0;
        }
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        int max=0;
        for(int i=1;i<zeroesat.size();i++)
        {
            int numberofzeroeshere=left[zeroesat.get(i)]+right[zeroesat.get(i)];
            if(numberofzeroeshere>left[zeroesat.get(max)]+right[zeroesat.get(max)])
            {
                max=i;
            }
        }
        System.out.println("Required Index: "+zeroesat.get(max));
    }
    public static void main(String[] args)
    {
       int  arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
       int  arr2[] =  {1, 1, 1, 1, 0};
        findZeroPos(arr);
        findZeroPos(arr2);
    }
}

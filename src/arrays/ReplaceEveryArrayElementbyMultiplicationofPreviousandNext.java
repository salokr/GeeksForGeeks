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
/*                                                                  TASK DESCRIPTION
Replace every array element by multiplication of previous and next
Given an array of integers, update every element with multiplication of previous and next elements with following exceptions. 
a) First element is replaced by multiplication of first and second.
b) Last element is replaced by multiplication of last and second last.
Input: arr[] = {2, 3, 4, 5, 6}
Output: arr[] = {6, 8, 15, 24, 30}

// We get the above output using following
// arr[] = {2*3, 2*4, 3*5, 4*6, 5*6} 
Source: Top 25 Interview Questions

*/
public class ReplaceEveryArrayElementbyMultiplicationofPreviousandNext 
{
    public static void replaceElements(int a[])
    {
        int prev=a[0];
        for(int i=0;i<a.length;i++)
        {
            int temp=a[i],next;
            if(i+1<a.length)
                next=a[i+1];
            else next=a[i];
            a[i]=prev*next;
            prev=temp;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a1[]={2, 3, 4, 5, 6};
        int ap[]={6, 8, 15, 24, 30};
        replaceElements(ap);
        replaceElements(a1);
    }
}

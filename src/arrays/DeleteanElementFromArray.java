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
Delete an element from array (Using two traversals and one traversal)
Given an array and a number ‘x’, write a function to delete ‘x’ from the given array.
Input:  arr[] = {3, 1, 2, 5, 90}, x = 2
Output: arr[] = {3, 1, 5, 90} 
*/
public class DeleteanElementFromArray 
{
    public static void deleteFromArray(int a[],int del)
    {
        int pos=-1;
        for(pos=0;pos<a.length;pos++)//<---- Can be skipped if element is guaranteed to be in the array
            if(a[pos]==del)
                break;
        if(pos==-1)
            return;
        int prev=a[a.length-1];
        for(int i=a.length-2;i>=pos;i--)
        {
            int temp=a[i];
            a[i]=prev;
            prev=temp;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a[]={3,1,2,5,90};
        deleteFromArray(a, 2);
    }
}

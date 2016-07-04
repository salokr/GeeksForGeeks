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
public class ReversalAlgorithmForArrayRotation
{
    public static void reverse(int  a[],int left,int right)
    {
        while(left<right)
        {
            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;right--;
        }
    }
    public static void rotate(int a[],int d)
    {
        reverse(a,0,d-1);
        reverse(a,d,a.length-1);
        reverse(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a[]={1, 2, 3, 4, 5, 6, 7};
        rotate(a, 2);
    }
}

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
A Product Array Puzzle
Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that 
prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}
*/
public class AProductArrayPuzzle 
{
    public static void solvePuzzle(int a[])
    {
        int pr=1;
        int prod[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            prod[i]=pr;
            pr*=a[i];
        }
        pr=1;
        for(int i=a.length-1;i>=0;i--)
        {
            prod[i]*=pr;
            pr*=a[i];
        }
        System.out.println(Arrays.toString(prod));
    }
    public static void main(String[] args)
    {
        int arr[] = {10, 3, 5, 6, 2};
        solvePuzzle(arr);
    }
}

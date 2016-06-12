/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
/*
Sort an array in wave form
Given an unsorted array of integers, sort the array into a wave like array.
An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
Examples:

 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                 {20, 5, 10, 2, 80, 6, 100, 3} OR
                 any other array that is in wave form

 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                 {10, 8, 20, 2, 6, 4} OR
                 any other array that is in wave form

 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                 any other array that is in wave form

 Input:  arr[] = {3, 6, 5, 10, 7, 20}
 Output: arr[] = {6, 3, 10, 5, 20, 7} OR
                 any other array that is in wave form
*/
public class SortAnArrayinWaveForm 
{
    /*Works Also when Array isn't sorted, in case of sorted array just replace each with R.H.S. value of each index*/
    public static void sortWave(int a[])
    {
        int n=a.length;
        Arrays.sort(a);
	        for(int i=1;i<a.length;i+=2)
	        {
	            int least=i;
	            if(a[i-1]<a[least])
	            least=i-1;
	            if(i+1<n&&a[i+1]<a[least])
	            least=i+1;
	            if(least!=i)
	            {
	                int temp=a[least];
	                a[least]=a[i];
	                a[i]=temp;
	            }
	        }
	        for(int i:a)
	        System.out.print(i+" ");
    }
    public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        
	        System.out.println();
	        t--;
	    }
	}
}

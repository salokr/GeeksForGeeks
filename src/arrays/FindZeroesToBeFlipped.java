/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author ashutosh                                             !!!!COPIED!!!!
 */

/*
                                                                 TASK DESCRIPTION
Find zeroes to be flipped so that number of consecutive 1’s is maximized
Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1s in array.

Examples:

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints 

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 1
Output:  7
We are allowed to flip maximum 1 zero. If we flip 
arr[7], we get 5 consecutive 1's which is maximum 
possible under given constraints.

Input:   arr[] = {0, 0, 0, 1}
         m = 4
Output:  0 1 2
Since m is more than number of zeroes, we can flip
all zeroes.
Source: http://www.careercup.com/question?id=5106425965576192
*/
public class FindZeroesToBeFlipped 
{
    public static void main (String[] args) 
	{
		//code
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        int m=sc.nextInt();
	        findZeroes(a,m);
	        t--;
	    }
	    
	}
	public static void findZeroes(int a[],int m)
	{
	    int l=0,r=0,max=0,zerocount=0,maxl=0,maxr=0;
	    while(r<a.length)
	    {
	        if(zerocount<=m)
	        {
	            if(a[r]==0)
	            zerocount++;
	            r++;
	        }
	        if(zerocount>m)
	        {
	            if(a[l]==0)
	            {
	                zerocount--;
	            }
	            l++;
	        }
	        int windowsize=r-l;
	        if(windowsize>max)
	        {
	            max=windowsize;
	            maxl=l;
	            maxr=r;
	        }
	    }
	    System.out.println(max+" "+maxl+" "+maxr);
	}
}

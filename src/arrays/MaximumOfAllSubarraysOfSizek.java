/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author ashutosh
 */
/*                                                                  TASK DESCRIPTION
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:

Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumOfAllSubarraysOfSizek  
{
    public static void findAllMax(int a[],int k)
    {
        Deque<Integer> deque =new ArrayDeque<>(k);
        for(int i=0;i<k;i++)
        {
            int current=a[i];
            while(!deque.isEmpty()&&a[deque.peekFirst()]<=current)
                deque.pollFirst();
            deque.addFirst(i);
            
        }
        for(int i=k;i<a.length;i++)
        {
            System.out.print(a[deque.peekLast()]+" ");
            if(!deque.isEmpty()&&deque.peekLast()>=i-k)
                deque.pollLast();
            int current=a[i];
            while(!deque.isEmpty()&&a[deque.peekFirst()]<current)
                deque.pollFirst();
            deque.addFirst(i);
        }
        System.out.println(deque.pollLast());
    }
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        findAllMax(a,k);
	        t--;
	    }
	}
}
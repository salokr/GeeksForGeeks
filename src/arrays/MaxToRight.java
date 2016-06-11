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
import java.util.*;
import java.lang.*;
import java.io.*;

class MaxToRight {
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
	        int maxtillnow=-1;
	        for(int i=n-1;i>=0;i--)
	        {
	            int curr=a[i];
	            a[i]=maxtillnow;
	            maxtillnow=maxtillnow>curr?maxtillnow:curr;
	        }
	        for(int i=0;i<n;i++)
	        System.out.print(a[i]+" ");
	        System.out.println();
	        t--;
	    }
	}
}
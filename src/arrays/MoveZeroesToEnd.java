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

class MoveZeroesToEnd {
    public static void partition(int a[],int pivot)
    {
        int r=a.length,i,count=0;
        for(i=0;i<r;i++)
        if(a[i]!=0)
        {
            count++;
            System.out.print(a[i]+" ");
        }
        
        
        for( i=0;i<r-count;i++)
            System.out.print("0 ");
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
	        partition(a,0);
	        System.out.println();
	        t--;
	    }
	}
}
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
class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int c=0;c<t;c++)
		{
		    int n=sc.nextInt();
		    int p=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    a[i]=sc.nextInt();
	        int l=0,r=a.length-1;
                Arrays.sort(a);
	        boolean isThere=false;
		    while(l<r)
		    {
		        int product=a[l]*a[r];
		        if(product==p)
		        {
		            isThere=true;
		            break;
		        }
		        else if(product<p)
		        l++;
		        else r--;
		    }
		    if(isThere)
		    System.out.println("Yes");
		    else
		    System.out.println("No");
		}
	}
}    


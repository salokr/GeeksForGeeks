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
public class GivenAnArray_A_AndANumberXCheckForPairIn_A_WithAumAsX
{
public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        boolean done=false;
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        Arrays.sort(a);
	        int l=0,r=a.length-1;
	        while(l<r)
	        {
	            if(a[l]+a[r]==k)
	            {
	                done=true;
	                break;
	            }
	            else if(a[l]+a[r]>k)
	            r--;
	            else l++;
	        }
	        if(done)
	        System.out.println("Yes");
	        else
	        System.out.println("No");
	        t--;
	    }
	}    
}

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

class DuplicateWithinK {
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
                //System.out.println("t"+t);
	        int k=Integer.parseInt(sc.next());
	        int n=Integer.parseInt(sc.next());
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=Integer.parseInt(sc.next());
	        findDuplicate(a,k);
	        t--;
	    }
	    
	}
	public static void findDuplicate(int a[],int k)
	{
	    HashSet<Integer> set=new HashSet<>();
	    for(int i=0;i<k;i++)
	    if(set.contains(a[i]))
	    {
	        System.out.println("True");
	        return;
	    }
	    else
	    {
	        set.add(a[i]);
	    }
	    for(int i=k;i<a.length;i++)
	    {
	       if(set.contains(a[i]))
	    {
	        System.out.println("True");
	        return;
	    }
	    else
	    {
	        int toremove=a[i-k];
	        set.remove(toremove);
	        set.add(a[i]);
	    }
	    }
            System.out.println("False");
            HashMap<Integer,Integer> map=new HashMap<>();
            
	}
}
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

class RelativeSorting {
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        HashMap<Integer,Integer> map=new HashMap<>();
	        int n=sc.nextInt();
	        int m=sc.nextInt();
	        int a[]=new int[n];
	        int b[]=new int[m];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        for(int i=0;i<m;i++)
	        b[i]=sc.nextInt();
                int remain=0;
	        for(int i=0;i<n;i++)
	        {
	            int key=a[i];
	            if(!map.containsKey(key))
	            map.put(key,0);
	            int frequency=map.get(key);
	            map.remove(key);
	            map.put(key,frequency+1);
                }
                for(int i=0;i<m;i++)
                {
                    int curr=b[i];
                    if(!map.containsKey(curr))
                        continue;
                    int freq=map.get(curr);
                    remain+=freq;
                    for(int j=0;j<freq;j++)
                        System.out.print(curr+" ");
                    map.remove(curr);
                }
                //System.out.println(" see"+map.size());
                int newsize=n-remain;
                int c[]=new int[newsize];
                int k=0;
                for(int i=0;i<n;i++)
                    if(map.containsKey(a[i]))
                    {
                        int freq=map.get(a[i]);
                        for(int po=0;po<freq;po++)
                            c[k++]=a[i];
                    }
                Arrays.sort(c);
                for(int p:c)
                    System.out.print(p+" ");
                t--;
	    }
	    
	}
}
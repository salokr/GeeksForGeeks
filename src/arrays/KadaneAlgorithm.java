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

class Kadene {
public static void findMaxSum(int a[])
	{
		int maxsum=a[0],currsum=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(currsum<0)
				currsum=a[i];
			else currsum+=a[i];
			if(currsum>maxsum)
				maxsum=currsum;
		}
		System.out.println(maxsum);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			findMaxSum(a);
			t--;
		}
	}
}
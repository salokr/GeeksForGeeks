/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
public class FindTheMissingNumber
{
public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int sum=(n*(n+1))/2,asum=0;
			for(int i=0;i<n-1;i++)
				asum+=sc.nextInt();
			System.out.println((sum-asum));
			t--;
		}
	}    
}

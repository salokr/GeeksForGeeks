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
public class FindTheNumberOccurringOddNumberOfTimes 
{
    public static void main(String[] arghs)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int xor=sc.nextInt();
			for(int i=1;i<n;i++)
				xor^=sc.nextInt();
			System.out.println(xor);
			t--;
		}
	}
}

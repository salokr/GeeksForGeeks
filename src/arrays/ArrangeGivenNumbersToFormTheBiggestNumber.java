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
/*                                                              TASK DESCRIPTION
Arrange given numbers to form the biggest number
Given an array of numbers, arrange them in a way that yields the largest value.
For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class ArrangeGivenNumbersToFormTheBiggestNumber {
	public static void main (String[] args) 
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    int n=sc.nextInt();
		    Integer a[]=new Integer[n];
		    for(int i=0;i<n;i++)
                        a[i]=sc.nextInt();
		    findNumber(a);
		    t--;
		//System.out.println(Arrays.toString(a));
                }
                
	}
	public static void findNumber(Integer a[])
	{
            Arrays.sort(a, new Comparator<Integer>(){
            public  int compare(Integer num1, Integer num2){
                Integer n1=Integer.parseInt(num1+""+num2+"");
                Integer n2=Integer.parseInt(num2+""+num1+"");
                //System.out.println(n1+" "+n2);
                return n2.compareTo(n1);
            }});
            for(int i=0;i<a.length;i++)
                System.out.print(a[i]);
            System.out.println();
	}
}

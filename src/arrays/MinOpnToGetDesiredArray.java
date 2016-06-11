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
/*                                                        TASK DESCRIPTION     
Count minimum steps to get the given desired array
Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

Incremental operations:Choose 1 element from the array and increment its value by 1.
Doubling operation: Double the values of all the elements of array.
We are given desired array target[] containing n elements. Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.

Sample test cases:

Input: target[] = {2, 3}
Output: 4
To get the target array from {0, 0}, we 
first increment both elements by 1 (2 
operations), then double the array (1 
operation). Finally increment second
element (1 more operation)

Input: target[] = {2, 1}
Output: 3
One of the optimal solution is to apply the 
incremental operation 2 times to first and 
once on second element.

Input: target[] = {16, 16, 16}
Output: 7
The output solution looks as follows. First 
apply an incremental operation to each element. 
Then apply the doubling operation four times. 
Total number of operations is 3+4 = 7


*/

public class MinOpnToGetDesiredArray 
{
    public static void getMinOperations(int a[])
    {
        int count=0;
        while(true)
        {
            /*FIRST MAKE ALL ODD NUMBERS POSITIVE*/
            int zerocount=0;
            for(int i=0;i<a.length;i++)
            {
                if(a[i]%2==1)
                {
                    a[i]--;
                    count++;
                }
                if(a[i]==0)
                    zerocount++;
            }
            if(zerocount==a.length)
                break;
            zerocount=0;
            for(int i=0;i<a.length;i++)
            {
                a[i]/=2;
                if(a[i]==0)
                    zerocount++;
            }
            count++;
            if(zerocount==a.length)
                break;
        }
        System.out.println(count);
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
	        getMinOperations(a);
	        t--;
	    }
	    
	}
}

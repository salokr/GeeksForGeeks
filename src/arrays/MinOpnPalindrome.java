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

/*
                                                                       TASK DESCRIPTION
Find minimum number of merge operations to make an array palindrome
Given an array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed operation on array is merge. Merging two adjacent elements means replacing them with their sum. The task is to find minimum number of merge operations required to make given array a ‘Palindrome’.

To make an array a palindromic we can simply apply merging operations n-1 times where n is the size of array (Note a single element array is alway palindrome similar to single character string). In that case, size of array will be reduced to 1. But in this problem we are asked to do it in minimum number of operations.

Example:

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
Expected time complexity is O(n).


*/

public class MinOpnPalindrome 
{
    /*public static void main(String[] ars)
    {
        int a[]={15,4,15};
        int b[]={1,4,5,1};
        int c[]={11,14,15,99};
        makePalindrome(a);
        makePalindrome(b);
        makePalindrome(c);
    }*/
    public static void makePalindrome(int a[])
    {
        int l=0,r=a.length-1,count=0;
        while(l<r)
        {
            if(a[l]==a[r])
            {
                l++;r--;
            }
            else if(a[l]<a[r])
            {
                a[l+1]=a[l+1]+a[l];
                l++;count++;
            }
            else
            {
                a[r-1]=a[r-1]+a[r];
                r--;count++;
            }
        }
        Util.printArray(a);
        System.out.println("Count: "+count);
    }
}

class GG {
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
		    makePalindrome(a);
		    t--;
		}
	}
	public static void makePalindrome(int a[])
    {
        int l=0,r=a.length-1,count=0;
        while(l<r)
        {
            if(a[l]==a[r])
            {
                l++;r--;
            }
            else if(a[l]<a[r])
            {
                a[l+1]=a[l+1]+a[l];
                l++;count++;
            }
            else
            {
                a[r-1]=a[r-1]+a[r];
                r--;count++;
            }
        }
        System.out.println(count);
    }
}

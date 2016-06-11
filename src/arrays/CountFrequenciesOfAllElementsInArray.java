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
Count frequencies of all elements in array in O(1) extra space and O(n) time
Given an unsorted array of n integers which can contain integers from 1 to n. 
Some elements can be repeated multiple times and some other elements can be absent from the array. 
Count frequency of all elements that are present and print the missing elements.
Examples:

Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1

Input: arr[] = {4, 4, 4, 4}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 0
        3 -> 0
        4 -> 4
*/
public class CountFrequenciesOfAllElementsInArray 
{
    public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
                        a[i]=sc.nextInt()-1;//subtract each element by 1 so that range is 0 to n-1
                    /*the logic is that if we have anything in between 0 to n-1 and then if we add some 
                    constant greater than it and then take modulus the old value will be
                    retained in it hence we can get frequency by dividng in last step*/
                    /*one thing to note is that since we have numbers from 1 to n, modulus will not save us from Array Out of bound error or exception,
                    also if we will try to use n for modulus then entries with exact n will not make modulus and division effective beacuse 
                    n/n is 1 and will be counted extra for that  index where it is stored
                    so we need to decrese one, now since everybody is in range 0 to n-1 we can use any value >=n for our purpose :D :D
                    */
		    for(int i=0;i<n;i++)
		    {
		        int current=a[i];
                        //System.out.print("current : "+current+" Current%n "+current%k);
		        a[current%n]+=n;
                        //System.out.println("current "+current+" a[c%n] "+a[current%k]);
		    }
		    for(int i=0;i<n;i++)
                        System.out.print((a[i]/n)+" ");
		    //System.out.println(a[0]/n);
		    t--;
		}
	}
}

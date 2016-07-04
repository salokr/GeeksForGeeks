/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.*;

/**
 *
 * @author ashutosh
 */
/*
Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. 
The rightmost element is always a leader. 
Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
Output:
Print all the leaders.
*/
public class LeadersInAnArray 
{
    public static void findLeaders(int a[])
    {
        StringBuilder leaders=new StringBuilder();
        int max=a[a.length-1];
        leaders.append(max);
        for(int i=a.length-2;i>=0;i--)
        {
            if(a[i]>max)
            {
                max=a[i];
                leaders.insert(0," ");
                leaders.insert(0,max);
            }
        }
        System.out.println(leaders);
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
            findLeaders(a);
            t--;
        }
    }
}

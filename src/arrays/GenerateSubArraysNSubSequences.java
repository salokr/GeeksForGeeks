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
public class GenerateSubArraysNSubSequences 
{
    public static void generateSubarraysRecursively(int a[],int current)//O(n^3)
    {
        int n=a.length;
        if(current==n)
            return;
        for(int i=current;i<n;i++)
        {
            System.out.print(a[i]+" ");
            for(int j=i+1;j<n;j++)
                System.out.print(a[j]+" ");
            System.out.println();
        }
        generateSubarraysRecursively(a, current+1);
    }
    public static void generateSubarrays(int a[])//O(n^2) but O(n) space
    {
        int n=a.length;
        int sub[]=new int[n];
        for(int i=0;i<n;i++)
        {
            sub[i]=a[i];
            System.out.println(a[i]+" ");
            for(int j=i+1;j<n;j++)
            {
                sub[j]=a[j];
                Util.printArray(sub, i,j);
            }
        }
    }
    public static void generateAllSubsequences(int a[],int current,int b[])
    {
        if(current==a.length-1)
        {
            b[current]=0;
            printSequences(a, b);
            b[current]=1;
            printSequences(a, b);
            return;
        }
        //for(int i=current;i<a.length-1;i++)
        {
            b[current]=0;
            generateAllSubsequences(a, current+1, b);
            b[current]=1;
            generateAllSubsequences(a, current+1, b);
        }
    }
    public static void main(String[] args)
    {
        int a[]={1,2,3};
        //generateSubarrays(a);
        int b[]=new int[a.length];
        generateAllSubsequences(a,0,b);
    }
    public static void printSequences(int a[],int b[])
    {
        for(int i=0;i<a.length;i++)
            if(b[i]==1)
                System.out.print(a[i]+" ");
        System.out.println();
    }
}

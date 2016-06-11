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
 * given array of +ve and -ve integers arrange in alternate fashion,order doesn't matter , extra elements can be shifted to right
 */
public class APaN 
{
    public static void arrangeElements(int a[])
    {
        //shift all poisitive elements to right and all negative elements to left
        int i=0,j=a.length-1;
        while(i<j)
        {
            while(i!=j&&a[i]<0)
                i++;
            while(j!=i&&a[j]>=0)
                j--;
            if(i!=j)
            {
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
    printArray(a);
    if(i==0||i==a.length)
        return;//if all elements are positive then i will be zero, if all -ve then i=n , no work to be done in both cases.
    //i points to first non-negative element and j points to first -ve element
    j=0;//begin from start
    while(j<i)
    {
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
        i=i+1;
        j+=2;
    }
        printArray(a);
    }
    public static void printArray(int[] a)
    {
        System.out.println();
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
   /* public static void main(String[] args)
    {
        int a[]={-2,3,4,-1};
        int b[]={-2,3,1};
        arrangeElements(a);
        arrangeElements(b);
    }
    */
}
//468 -901 335 -152 501 -291 170 -381 725 -420 479 -715 359 -717 963 -894 465 -446 706 -725 146 -770 282 -537 828 -868 962 -911 492 -666 996 -298 943 -34 828 -893 437 -702 392 -810 605 -321
//468 -901 335 -152 501 -291 170 -381 725 -420 479 -715 359 -717 963 -894 465 -446 706 -725 146 -770 282 -537 828 -868 962 -911 492 -666 996 -298 943 -34 828 -893 437 -702 392 -810 605 -321
// 311 -555 618 -797 814 -302 515 -223 310 -7 617 -843 936 -608 452 -988 601 -701 250 -194 520 -484
class GfG {
	public static void main (String[] args) 
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    int positive=0,negative=0;
		    int parray[]=new int[n];
		    int narray[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		        if(a[i]<0)
		        {
		            narray[negative]=a[i];
		            negative++;
		        }
		        else 
		        {
		            parray[positive]=a[i];
		            positive++;
		        }
		    }
		    int l=0,r=0;
		    for(int i=0;i<n;i++)
		    {
		        if(r>=negative)
		        System.out.print(parray[l++]+" ");
		        else if(l>=positive)
		        System.out.print(parray[r++]+" ");
		        else
		        {
		            System.out.print(parray[l++]+" ");
		            if(i++<n)
		            System.out.print(narray[r++]+" ");
		        }
		    }
		    t--;
                    System.out.println();
		}
	}
}
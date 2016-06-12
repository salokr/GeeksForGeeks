/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author ashutosh
 * given sorted array, find the closest pair from two sorted arrays
 */
public class FindTheClosestPair 
{
    public static void main(String[] args)
    {
        int a1[]={1,4,5,7};
        int a2[]={10,20,30,40};
        int x1=32,x2=50;
        findPairs(a1, a2, x1);
        findPairs(a1, a2, x2);
    }
    public static void findPairs(int a[],int b[],int x)
    {
        int l=0,r=b.length-1;
        int mindiff=Math.abs(a[l]+b[r]-x),aindex=l,bindex=r;
        while(l<a.length-1&&r>0)
        {
            //keep l fixed
            int updateval=a[l]+b[r];
            //keep r fixed
            if(updateval<=x)
            {
                l++;  
            }
            else
            {
                r--;
            }
            //System.out.println(min);
            int sum=Math.abs(updateval-x);
            if(sum<mindiff)
            {
                mindiff=sum;
                aindex=l;
                bindex=r;
            }
        }
        System.out.println("Aindex: "+a[aindex]+" Bindex: "+b[bindex]+" Mindiff: "+mindiff);
    }
}

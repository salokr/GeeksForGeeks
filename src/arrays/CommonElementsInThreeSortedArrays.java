/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import algorithms.*;

/**
 *
 * @author ashutosh
 * Given Three Arrays Find Intersection Of All Three
 */
public class CommonElementsInThreeSortedArrays 
{
    public static void main(String[] args)
    {
        int a[]={1,5,10,20,40,80};
        int b[]={6,7,20,80,100};
        int c[]={3,4,15,20,30,70,80,120};
        findIntersection(a, b, c);
        int d[]={1,5,5};
        int e[]={3,4,5,5,10};
        int f[]={5,5,10,20};
        findIntersection(d, e, f);
    }
    public static void findIntersection(int a[],int b[],int c[])
    {
        int l1=0,l2=0,l3=0;
        while(l1<a.length&&l2<b.length&&l3<c.length)
        {
            if(a[l1]==b[l2]&&b[l2]==c[l3])
            {
                System.out.print(a[l1]+" ");
                l1++;l2++;l3++;
            }
            else if(a[l1]<b[l2])
                l1++;
            else if(b[l2]<c[l3])
                l2++;
            else
                l3++;
            
        }
        System.out.println();
    }
}

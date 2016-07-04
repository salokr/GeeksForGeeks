/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.HashSet;
import java.util.SortedMap;

/**
 *
 * @author ashutosh
 */
public class UnionAndIntersectionOfTwoSortedArrays 
{
    public static void findUnion(int a[],int b[])
    {
        int l=0,r=0;
        while(l<a.length&&r<b.length)
        {
            if(a[l]<b[r])
            {
                System.out.print(a[l]+" ");
                l++;
            }
            else if(a[l]>b[r])
            {
                System.out.print(b[r]+" ");
                r++;
            }
            else//both are equal
            {
                int curr=a[l];
                System.out.print(curr+" ");
                while(l<a.length&&r<b.length&&a[l]==curr&&curr==b[r])
                {
                    l++;r++;
                }
            }
        }
        while(l<a.length)
            System.out.print(a[l++]);
        while(r<b.length)
            System.out.print(b[r++]);
        System.out.println();
    }
    public static void main(String[] args)
    {
        int a[]={1,2,3,4,5,7};
        int b[]={2,3,5,6};
        byHashing(a, b);
    }
    public static void byHashing(int a[],int b[])
    {
        HashSet<Integer> set=new HashSet<>();
        int i=0,j=0;
        while(i<a.length&&j<b.length)
        {
            if(a[i]<b[j])
                set.add(a[i++]);
            else
                set.add(b[j++]);
        }
        while(i<a.length)
            set.add(a[i++]);
        while(j<b.length)
            set.add(b[j++]);
        for(Object po:set.toArray())
            System.out.print(po+" ");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ashutosh
 */
public class ClosestPairInArray 
{
    public static void findPair(int a[],int k)
    {
        int l=0,r=a.length-1,id1=-1,id2=-1;
        int sum=Integer.MAX_VALUE;
        while(l<r)
        {
            if(Math.abs(a[l]+a[r]-k)<sum)
            {
                id1=l;id2=r;
                sum=Math.abs(a[l]+a[r]-k);
            }
            if(a[l]+a[r]<=k)
                l++;
            else
                r--;
        }
        System.out.println("Found Pair "+a[id1]+" and "+a[id2]);
    }
    public static void main(String[] args)
    {
        int a[]={10,22,28,29,30,40},x=52;
        int b[]={1,3,4,7,10},y=15;
        findPair(a, x);
        findPair(b, y);
    }
}

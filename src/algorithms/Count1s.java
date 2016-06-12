/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ashutosh
 * Find number of one's in binary array sorted in non-increasing order
 */
public class Count1s 
{
    public static void main(String[] args)
    {
        int a[]={1,1,0,0,0,0,0};
        int b[]={1,1,1,1,1,1,1};
        int c[]={0,0,0,0,0,0,0};
        System.out.println(getOnes(a)+1);
        System.out.println(getOnes(b)+1);
        System.out.println(getOnes(c)+1);
    }
    public static int getOnes(int a[])
    {
        return getPos(a, 0, a.length-1);
    }
    public static int getPos(int a[],int beg,int end)
    {
        if(beg>end)
            return -1;
        if(a[end]==1)
            return end;
        if(a[beg]==0)
            return beg-1;
        int mid=(beg+end)/2;
        if(a[mid]==1&&a[mid+1]==0)
            return mid;
        else if(a[mid]==0)
            return getPos(a, beg, mid-1);
        else return getPos(a, mid+1, end);
    }
}

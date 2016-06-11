package arrays;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 * Absolute Distinct Count In SORTED Array
 */
public class ADCiSA 
{
    public static void main(String[] args)
    {
        int a[]={-3,-2,0,3,4,5};
        int b[]={-1,-1,-1,-1,0,1,1,1,1};
        int c[]={0,0,0};
        int d[]={-1,-1,-1,-1,0};
        System.out.println("Method 1 O/P : "+getCountM1(a)+" : "+getCountM1(b)+" : "+getCountM1(c)+" : "+getCountM1(d));
        System.out.println("Method 2 O/P : "+getCount(a)+" : "+getCount(b)+" : "+getCount(c)+" : "+getCount(d));
    }
    public static int getCountM1(int a[])
    {
        /*Takes Extra Space but linear time*/
        LinkedList<Integer> done=new LinkedList<>();
        for(int i=0;i<a.length;i++)
        {
            if(!done.contains(Math.abs(a[i])))
                done.add(Math.abs(i));
        }
        return done.size();
    }
    public static int getCount(int a[])
    {
        /*Linear Time With no extra space*/
        int count=a.length;
        int beg=0,end=count-1;
        while(beg<end)
        {
            /*remove repeated from left*/
            while(beg!=end&&a[beg]==a[beg+1])
            {
                count--;
                beg++;
            }
            while(end!=beg&&a[end]==a[end-1])
            {
                count--;
                end--;
            }
            if(beg==end)
                break;
            int sum=a[beg]+a[end];
            if(sum==0)
            {
                count--;
                beg++;
                end--;
            }
            else if(sum<0)
                beg++;
            else 
                end--;
        }
        return count;
    }
}

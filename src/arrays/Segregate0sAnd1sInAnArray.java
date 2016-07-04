/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author ashutosh
 */
public class Segregate0sAnd1sInAnArray
{
    public static void segregate(int a[])
    {
        int l=0,i=0;
        while(i<a.length)
        {
            if(a[i]==0)
            {
                int temp=a[i];
                a[i]=a[l];
                a[l]=temp;
                l++;
            }
            i++;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int a[]={0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate(a);
    }
}

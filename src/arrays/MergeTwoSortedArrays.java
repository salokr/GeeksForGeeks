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
/*                                           OBJECTIVE:- MERGE TWO SORTED ARRAYS WITH O(1) EXTRA SPACE ONLY                                   */
public class MergeTwoSortedArrays 
{
    public static void mergeArrays(int a[],int b[])
    {
        int l=0,r=0;
        while(l<a.length&&r<b.length)
        {
            if(a[l]<=a[r])
            {
                l++;
                continue;
            }
            int temp=a[l];
            a[l]=b[r];
            b[r]=temp;
            l++;
            reSort(b);
        }
        Util.printArray(a);
        Util.printArray(b);
    }
    public static void reSort(int a[])
    {
        int newitem=a[0];
        int i=1;
        while(i<a.length&&newitem>a[i])
        {
            a[i-1]=a[i];
            i++;
        }
        a[i-1]=newitem;
    }
    public static void main(String[] args)
    {
        int a[]={1,5,9,10,15,20};
        int b[]={2,3,8,13};
        mergeArrays(a, b);
    }
}

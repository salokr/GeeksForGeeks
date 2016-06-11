/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divideandconquer;

/**
 *
 * @author ashutosh
 */
public class MajorityElement 
{
    public static int linearME(int[] a)
    {
        int mid=a.length/2;
        for(int i=0;i<mid;i++)
        {
            if(a[i]==a[i+mid])
                return a[i];
        }
        return -1;
    }
    public static int searchDAC(int[] a)
    {
        return 0;
    }
    public static void main(String[] args)
    {
        int a[]={1,1,1,1,1,1,1,7,8,9};
        int b[]={2,3,4,5,5,5,5,5,5,6};
        int c[]={1,2,3,4,4,4,4,5,6,7};
        int d[]={2,3,3,4};
        System.out.println(linearME(a));
        System.out.println(linearME(b));
        System.out.println(linearME(c));
        System.out.println(linearME(d));
        
        
    }
    
}

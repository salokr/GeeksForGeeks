/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ashutosh
 * arrange array in such a way that mid is peak element i.e. a[mid-1]>=a[mid]<=a[mid+1]
 */
public class SortInWaveForm 
{
    public static void main(String[] args)
    {
        int a[]={10,5,6,3,2,20,100,80};
        int b[]={20,10,8,6,4,2};
        int c[]={2,4,6,8,10,20};
        int d[]={3,6,5,10,7,20};
        waveForm(a);
        waveForm(b);
        waveForm(c);
        waveForm(d);
    }
    public static void waveForm(int a[])
    {
        for(int i=1;i<a.length;i+=2)
        {
            int left=i-1;
            int current=i;
            int smallest=a[left]<a[current]?left:current;
            if(i+1<=a.length-1&&a[i+1]<a[smallest])
                smallest=i+1;
            if(i!=smallest)
            {
                int temp=a[i];
                a[i]=a[smallest];
                a[smallest]=temp;
            }
        }
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}

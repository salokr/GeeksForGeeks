/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;


import java.util.*;

/**
 *
 * @author ashutosh
 */


public class SortByFrequency 
{
    public static void doSorting(int a[])
    {
        Hashtable<Integer,Integer> table=new Hashtable<>();
        for(int i=0;i<a.length;i++)
        {
            if(!table.containsKey(a[i]))
                table.put(a[i],0);
            int freq=table.get(a[i]);
            table.remove(a[i]);
            table.put(a[i], freq+1);
        }
        Data[] temp=new Data[table.size()];
        Object[] keyset=table.keySet().toArray();
        for(int i=0;i<keyset.length;i++)
        {
            int key=Integer.parseInt(""+keyset[i]);
            temp[i]=new Data(key,table.get(key));
            System.out.println(temp[i]);
        }
        Arrays.sort(temp,new Comparator<Data>()
        {

            @Override
            public int compare(Data o1, Data o2) 
            {
                if(o1.freq==o2.freq)
                {
                    if(o1.data>o2.data)
                    return 1;
                    else return -1;
                }
                else return o2.freq-o1.freq;
            }
        });
        for(int i=0;i<temp.length;i++)
        {
            int key=temp[i].data;
            int freq=table.get(key);
            for(int j=0;j<freq;j++)
                System.out.print(key+" ");
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            doSorting(a);
            System.out.println();
            t--;
        }
    }
}
class Data
{
    int data;
    int freq;
    public Data(int n,int freq)
    {
        this.data=n;
        this.freq=freq;
    }
    public String toString()
    {
        return data+"";
    }
}
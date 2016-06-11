/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author ashutosh
 */
public class SortByFrequency 
{
    public static void doSorting(int a[])
    {
        TreeMap<Data,Integer> map=new TreeMap<>(new Comparator<Data>(){

            @Override
            public int compare(Data o1, Data o2) {
                return o1.freq-o2.freq; //To change body of generated methods, choose Tools | Templates.
            }
        });
        for(int i=0;i<a.length;i++)
        {
            Data d=new Data(a[i]);
            if(!map.containsValue(a[i]))
                map.put(d,a[i]);
            else
            {
                
            }
            
        }
        Set<Data> keyset=map.keySet();
        for(Data n:keyset)
            System.out.println(map.get(n)+" ");
    }
    public static void main(String[] args)
    {
        int a[]={2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        doSorting(a);
    }
}
class Data
{
    int data;
    int freq;
    public Data(int n)
    {
        this.data=n;
        freq=1;
    }
    public void increaseFreq()
    {
        freq++;
    }
    public String toString()
    {
        return ""+freq;
    }
}
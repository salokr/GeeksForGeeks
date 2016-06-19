/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Hashtable;

/**
 *
 * @author ashutosh
 */

/*
Given an array of of size n and a number k, find all elements that appear more than n/k times
Given an array of size n, find all elements in array that appear more than n/k times. 
For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4,
then the output should be [2, 3]. Note that size of array is 8 (or n = 8), 
so we need to find all elements that appear more than 2 (or 8/4) times. 
There are two elements that appear more than two times, 2 and 3.

A simple method is to pick all elements one by one. For every picked element,
count its occurrences by traversing the array, if count becomes more than n/k, then print the element. 
Time Complexity of this method would be O(n2).

A better solution is to use sorting. First, sort all elements using a O(nLogn) algorithm. 
Once the array is sorted, we can find all required elements in a linear scan of array. 
So overall time complexity of this method is O(nLogn) + O(n) which is O(nLogn).
*/
public class GivenAnArrayofSizenAndaNumberkFindAllElementsThatAppearMoreThannBYkTimes 
{
                                                        //GEEKS SOLUTION    
public static void findElements(int a[],int k)
{
    MyData temp[]=new MyData[k-1];
    for(int i=0;i<k-1;i++)
        temp[i]=new MyData();
    for(int i=0;i<a.length;i++)
    {
        int j;
        for(j=0;j<k-1;j++)
        {
            if(a[i]==temp[j].key)
            {
                temp[j].inc();
                break;
            }
        }
        if(j==k-1)//means element is not found in candidate array decreement count of each one
        {
            //check if current element can be filled anywhere
            int l;
            for(l=0;l<k-1;l++)
                if(temp[l].count==0)
                {
                    temp[l]=new MyData(a[i]);
                    break;
                }
            if(l==k-1)//still no place for current element
            for(j=0;j<k-1;j++)
                temp[j].dec();
        }
        
    }
    for(int i=0;i<k-1;i++)
        if(getCount(a, temp[i].key)>a.length/k)
            System.out.println(temp[i]);
}
public static int getCount(int a[],int k)
{
    int count=0;
    for(int i:a)
        if(i==k)
            count++;
    return count;
}

public static void main(String[] args)
{
 int arr1[] = {4, 5, 6, 7, 8, 4, 4};
    findElements(arr1, 3);
    hashSolution(arr1,3);
}
public static void hashSolution(int a[],int k)
{
    Hashtable<Integer,Integer> table=new Hashtable<>();
    for(int i=0;i<a.length;i++)
    {
        if(!table.containsKey(a[i]))
        {
            table.put(a[i],0);
        }
        int frequency=table.get(a[i]);
        table.replace(a[i],frequency+1);
    }
    Object[] keyset=table.keySet().toArray();
    for(int i=0;i<keyset.length;i++)
    {
        int freq=table.get(Integer.parseInt((keyset[i])+""));
        if(freq>a.length/k)
            System.out.println(keyset[i]+"");
    }
}



}

class MyData
{
    int key;
    int count;
    public MyData()
    {
        this.key=Integer.MIN_VALUE;
        this.count=0;
    }
    public MyData(int key)
    {
        this.key=key;
        count=1;
    }
    public  void inc()
    {
        count++;
    }
    public void dec()
    {
        count--;
    }
    public String toString()
    {
        return ""+key;
    }
}

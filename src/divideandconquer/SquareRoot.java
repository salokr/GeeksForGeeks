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
public class SquareRoot 
{
    long getSquareRoot(int num)
    {
        int count=0;
        long  i,result=0;
        for(i=0;;)
        {
            count++;
            //System.out.println(result+" "+ i);
            result=i*i;
            if(result>num)
                break;
            i++;
        }
        System.out.println("Simple Approach Takes "+count+" steps");
        return i-1;
            //O(sqrt(n))
    }
    int getSquareRootDAC(int num)
    {
        if(num==0||num==1)
            return num;
        int beg=1,end=num/2,mid=0,count=0;
        while(beg<=end)
        {
            count++;
            mid=(beg+end)/2;
            int result=mid*mid;
            if(result>num)
                end=mid-1;
            else if(result<num)
                beg=mid+1;
            else
            {
                System.out.println("Simple Approach Takes "+count+" steps");
                return mid;
            }
        }
        System.out.println("DAC Approach Takes "+count+" steps");
        return beg-1;
    //O(logn)
    }
    public static void main(String[] args)
    {
        int n=Integer.MAX_VALUE;
        System.out.println("For "+Integer.MAX_VALUE);
        System.out.println(new SquareRoot().getSquareRoot(n));
        System.out.println(new SquareRoot().getSquareRootDAC(n));
    }
}
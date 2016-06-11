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
public class MedianOfTwoSortedArrays 
{
    public double getMedian(int a[],int b[],int astart,int aend,int bstart,int bend)
    {
        double median=0;
        //if both have less than two elements then only start process of finding median 
        if(Math.abs(bend-bstart)+1<=2&&Math.abs(aend-astart)+1<=2)
        {
            int size=Math.abs(bend-bstart)+1+Math.abs(aend-astart)+1;
        
            //Case if both have exactly four elements
            if(size==4)
            median=(Math.max(a[astart],b[bstart])+Math.min(a[aend], b[bend]))/2.0;
            else if(size==3)
            {
                //find out separately as we don't know which has size 2 
                int size2=Math.abs(bend-bstart)+1;
                //if b has size of two then
                if(size2==2)
                    median=Math.max(b[bend],Math.min(b[bstart],a[astart]));
                else 
                    median=Math.max(a[aend],Math.min(a[astart],b[bstart]));
            }
            else if(size==2)
            {
                //both have exactly one-one elements
                median=(a[astart]+b[bstart])/2.0;
            }
            
        }
        else
        {
        int mid1=(astart+aend)/2;
        int mid2=(bstart+bend)/2;
        if(a[mid1]>b[mid2])
            median=getMedian(a, b, astart, mid1, mid2, bend);
        else if(a[mid1]<b[mid2])
            median=getMedian(a,b,mid1,aend,bstart,mid2);
        else median=a[astart];
        }
        return median;
    }
    public static void main(String[] args)
    {
        int a[]={1,2,3,4,5};
        int b[]={6,7,8,9};
        System.out.println(new MedianOfTwoSortedArrays().getMedian(a,b,0,a.length-1,0,b.length-1));
    }
    
}

package arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
public class CheckForMajorityElementInASortedArray
{
    //calculate first occurence and check whether it's a perfect candidate or not ?
    public static int leftIndex(int a[],int beg,int end,int key)
    {
        if(beg>end)
            return -1;//x isn't present
        if(a[beg]==key)
            return beg;
        int mid=(beg+end)/2;
        if(mid>0&&a[mid]==key&&a[mid-1]<key)
            return mid;
        else if(a[mid]>=key)
            return leftIndex(a, beg, mid-1, key);
        else return leftIndex(a, mid+1, end, key);
    }
    public static void checkMajority(int a[],int x)
    {
        int left=leftIndex(a, 0,a.length-1, x);
        if(left==-1)
        {
            System.out.println("Element Is Not In Array");    
            return;
        }
        if(left+a.length/2<a.length&&a[left+a.length/2]==x)//since occurence must be GT n/2, a.left/2 gives us exact n/2 occurence but 
            System.out.println(x+" Is Majority Element");//since we are required GT than it, so add current index too and if at that index
        else //x is present we are done it doesn't matter it appears also after that we are required to verify that excluding its first occurence
            System.out.println(x+" Isn't Majority Element");//x is present atleast n/2 times....
       
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 3, 3, 3, 10};
        checkMajority(arr, 3);
        int a[]={1, 1, 2, 4, 4, 4, 6, 6};
        checkMajority(a, 4);
        int b[]={1, 1, 1, 2, 2};
        checkMajority(b, 1);
    }
}

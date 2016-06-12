/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ashutosh
 * Search in almost sorted array, where some a[i] may got exchanged with a[i+1] or a[i-1]
 */
public class SearchInAlmostSorted 
{
    public static void main(String[] args)
    {
        int a[]={10,3,40,20,50,80,70};
        int key1=40,key2=10,key3=70;
        System.out.println(binarySearch(a,0,a.length-1,key1));
        System.out.println(binarySearch(a,0,a.length-1,key2));
        System.out.println(binarySearch(a,0,a.length-1,key3));
        
        
        System.out.println(doBinarySearch(a,0,a.length-1,key1));
        System.out.println(doBinarySearch(a,0,a.length-1,key2));
        System.out.println(doBinarySearch(a,0,a.length-1,key3));
    }
    public static int doBinarySearch(int a[],int beg,int end,int key)
    {
        if(beg>end)
            return -1;//Element Not Present In Array
        int mid=(beg+end)/2;
        if(a[mid]==key)
            return mid;
        if(mid>beg&&a[mid-1]==key)//first condition to avoid array out of bound exception think about only one element in the array
            return mid-1;
        if(mid<end&&a[mid+1]==key)//first condition to avoid array out of bound exception think about only one element in the array
            return mid+1;
        
        //here means we have mid-1 mid mid+1 all doesn't have required elements
        //see if a[mid]>key  then surely we have to search in left subarray, why ? since if a[mid]&&a[mid-1] are exchanged or not if a[mid]>key then a[mid-2]<=key
        if(a[mid]<=key)
            return doBinarySearch(a, mid+2, end, key);
        else
            return doBinarySearch(a, beg, mid-2, key);
        
    }

public static int binarySearch(int arr[], int l, int r, int x)
{
   if (r >= l)
   {
        int mid = l + (r - l)/2;

        if (arr[mid] == x)  return mid;
        if (mid > l && arr[mid-1] == x) return (mid - 1);
        if (mid < r && arr[mid+1] == x) return (mid + 1);
        if (arr[mid] > x) return binarySearch(arr, l, mid-2, x);
        return binarySearch(arr, mid+2, r, x);
   }
   return -1;
}

}

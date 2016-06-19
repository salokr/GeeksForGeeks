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
/*
Longest Increasing Subsequence Size (N log N)
After few months of gap posting an algo. The current post is pending from long time, and many readers (e.g. here, here, here may be few more, I am not keeping track of all) are posting requests for explanation of the below problem.

Given an array of random numbers. Find longest increasing subsequence (LIS) in the array. I know many of you might have read recursive and dynamic programming (DP) solutions. There are few requests for O(N log N) algo in the forum posts.

For the time being, forget about recursive and DP solutions. Let us take small samples and extend the solution to large instances. Even though it may look complex at first time, once if we understood the logic, coding is simple.

Consider an input array A = {2, 5, 3}. I will extend the array during explanation.

By observation we know that the LIS is either {2, 3} or {2, 5}. Note that I am considering only strictly increasing sequences.

Let us add two more elements, say 7, 11 to the array. These elements will extend the existing sequences. Now the increasing sequences are {2, 3, 7, 11} and {2, 5, 7, 11} for the input array {2, 5, 3, 7, 11}.

Further, we add one more element, say 8 to the array i.e. input array becomes {2, 5, 3, 7, 11, 8}. Note that the latest element 8 is greater than smallest element of any active sequence (will discuss shortly about active sequences). How can we extend the existing sequences with 8? First of all, can 8 be part of LIS? If yes, how? If we want to add 8, it should come after 7 (by replacing 11).

Since the approach is offline (what we mean by offline?), we are not sure whether adding 8 will extend the series or not. Assume there is 9 in the input array, say {2, 5, 3, 7, 11, 8, 7, 9 …}. We can replace 11 with 8, as there is potentially best candidate (9) that can extend the new series {2, 3, 7, 8} or {2, 5, 7, 8}.

Our observation is, assume that the end element of largest sequence is E. We can add (replace) current element A[i] to the existing sequence if there is an element A[j] (j > i) such that E < A[i] < A[j] or (E > A[i] < A[j] – for replace). In the above example, E = 11, A[i] = 8 and A[j] = 9.

In case of our original array {2, 5, 3}, note that we face same situation when we are adding 3 to increasing sequence {2, 5}. I just created two increasing sequences to make explanation simple. Instead of two sequences, 3 can replace 5 in the sequence {2, 5}.

I know it will be confusing, I will clear it shortly!

The question is, when will it be safe to add or replace an element in the existing sequence?

Let us consider another sample A = {2, 5, 3}. Say, the next element is 1. How can it extend the current sequences {2,3} or {2, 5}. Obviously, it can’t extend either. Yet, there is a potential that the new smallest element can be start of an LIS. To make it clear, consider the array is {2, 5, 3, 1, 2, 3, 4, 5, 6}. Making 1 as new sequence will create new sequence which is largest.

The observation is, when we encounter new smallest element in the array, it can be a potential candidate to start new sequence.

From the observations, we need to maintain lists of increasing sequences.

In general, we have set of active lists of varying length. We are adding an element A[i] to these lists. We scan the lists (for end elements) in decreasing order of their length. We will verify the end elements of all the lists to find a list whose end element is smaller than A[i] (floor value).

Our strategy determined by the following conditions,

1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.

2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].

3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.

Note that at any instance during our construction of active lists, the following condition is maintained.

“end element of smaller list is smaller than end elements of larger lists”.

It will be clear with an example, let us take example from wiki {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}.

A[0] = 0. Case 1. There are no active lists, create one.
0.
-----------------------------------------------------------------------------
A[1] = 8. Case 2. Clone and extend.
0.
0, 8.
-----------------------------------------------------------------------------
A[2] = 4. Case 3. Clone, extend and discard.
0.
0, 4.
0, 8. Discarded
-----------------------------------------------------------------------------
A[3] = 12. Case 2. Clone and extend.
0.
0, 4.
0, 4, 12.
-----------------------------------------------------------------------------
A[4] = 2. Case 3. Clone, extend and discard.
0.
0, 2.
0, 4. Discarded.
0, 4, 12.
-----------------------------------------------------------------------------
A[5] = 10. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 10.
0, 4, 12. Discarded.
-----------------------------------------------------------------------------
A[6] = 6. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 6.
0, 2, 10. Discarded.
-----------------------------------------------------------------------------
A[7] = 14. Case 2. Clone and extend.
0.
0, 2.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[8] = 1. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2. Discarded.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[9] = 9. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2, 6.
0, 2, 6, 9.
0, 2, 6, 14. Discarded.
-----------------------------------------------------------------------------
A[10] = 5. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 5.
0, 2, 6. Discarded.
0, 2, 6, 9.
-----------------------------------------------------------------------------
A[11] = 13. Case 2. Clone and extend.
0.
0, 1.
0, 1, 5.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[12] = 3. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 5. Discarded.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[13] = 11. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 2, 6, 9.
0, 2, 6, 9, 11.
0, 2, 6, 9, 13. Discarded.
-----------------------------------------------------------------------------
A[14] = 7. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9. Discarded.
0, 2, 6, 9, 11.
----------------------------------------------------------------------------
A[15] = 15. Case 2. Clone and extend.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9, 11.
0, 2, 6, 9, 11, 15. <-- LIS List
----------------------------------------------------------------------------
It is required to understand above strategy to devise an algorithm. Also, ensure we have maintained the condition, “end element of smaller list is smaller than end elements of larger lists“. Try with few other examples, before reading further. It is important to understand what happening to end elements.

Algorithm:

Querying length of longest is fairly easy. Note that we are dealing with end elements only. We need not to maintain all the lists. We can store the end elements in an array. Discarding operation can be simulated with replacement, and extending a list is analogous to adding more elements to array.

We will use an auxiliary array to keep end elements. The maximum length of this array is that of input. In the worst case the array divided into N lists of size one (note that it does’t lead to worst case complexity). To discard an element, we will trace ceil value of A[i] in auxiliary array (again observe the end elements in your rough work), and replace ceil value with A[i]. We extend a list by adding element to auxiliary array. We also maintain a counter to keep track of auxiliary array length.

Bonus: You have learnt Patience Sorting technique partially :).

Here is a proverb, “Tell me and I will forget. Show me and I will remember. Involve me and I will understand.” So, pick a suit from deck of cards. Find the longest increasing sub-sequence of cards from the shuffled suit. You will never forget the approach. :)
*/


public class LongestIncreasingSubsequenceSize
{
    public static void main(String[] ars)
    {
         int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
         findSize(A);
    }
    public static void findSize(int a[])
    {
        int sol[]=new int[a.length];
        sol[0]=a[0];
        int solsize=1;
        for(int i=1;i<a.length;i++)
        {
            
            /*See: the idea is just to find the SIZE of longest such subsequence, so we can do like this, if new element is greater than
            all element in current list we can append it to the current list, see it doesn't matter where it should be inserted, if its greatest
            it should be at end of all the sublist,and if some sublist is going to exceed the length, it will somehow somewhere in final solution. 
            */
            //case 2 : if current is greater than tail element append to end
            if(a[i]>sol[solsize-1])
            {
                sol[solsize]=a[i];
                solsize++;
            }
            //case 1: if current is smallest then start a new sequence
            else if(a[i]<sol[0])
                sol[0]=a[i];
            //case 3: if current in between create a newlist(in same solution array) and discard everyother list of same size,
            //remember to keep smallest element of every such sublist smallest.
            else
            {
                //find the element which is largest but smaller than current element in solution array.
                //linear search will result in O(n^2) solution try binary search, rememeber if this list is result then it will cross the solution array till now in future.
                //int ceill=getCeilIndex(sol, solsize, a[i]);
                int ceil=getCeil(sol,0,solsize-1,a[i]);
                sol[ceil+1]=a[i];
                
            }
        }
        System.out.println(solsize);
    }
    //Linear search FIRST
    public static int getCeilIndex(int a[],int size,int key)
    {
        int ceil=size;
        for(int i=0;i<size;i++)
            if(a[i]>key)//first element greater than key
            {
                ceil=i;
                break;
            }
    return ceil;
    }
    //try to get ceil in logn time to fasten the algorithm
    public static int getCeil(int a[],int start,int end,int key)//Returns the LAST ELEMENT INDEX smaller than Key
    {
        if(a[start]>key)
            return start;
        if(a[end]<key)
            return end;
        int mid=(start+end)/2;
        if(mid<end&&a[mid]<key&&a[mid+1]>key)
            return mid;
        else if(a[mid]>key)
            return getCeil(a, start, mid-1, key);
        else return getCeil(a, mid+1,end, key);
    }
}

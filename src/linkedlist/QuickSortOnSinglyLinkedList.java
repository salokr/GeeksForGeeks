/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;
/**
 *
 * @author ashutosh
 */

/*
QuickSort on Singly Linked List
QuickSort on Doubly Linked List is discussed here. QuickSort on Singly linked list was given as an exercise. 
Following is C++ implementation for same. 
The important things about implementation are, it changes pointers rather swapping data and time complexity 
is same as the implementation for Doubly Linked List.
In partition(), we consider last element as pivot. We traverse through the current list and if a node has value greater than pivot, 
we move it after tail. If the node has smaller value, we keep it at its current position.
In QuickSortRecur(), we first call partition() which places pivot at correct position and returns pivot. 
After pivot is placed at correct position, we find tail node of left side (list before pivot) and recur for left list. 
Finally, we recur for right list.
*/

public class QuickSortOnSinglyLinkedList
{
    public static void doQuickSort(Linked_List ll)
    {
        
    }
}

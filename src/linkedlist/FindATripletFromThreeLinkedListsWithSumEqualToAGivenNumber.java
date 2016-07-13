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
Find a triplet from three linked lists with sum equal to a given number
Given three linked lists, say a, b and c, find one node from each list such that the sum of the values of the nodes is equal to a given number. 
For example, if the three linked lists are 12.6.29, 23.5.8 and 90.20.59, and the given number is 101,
the output should be tripel “6 5 90″.
In the following solutions, size of all three linked lists is assumed same for simplicity of analysis. 
The following solutions work for linked lists of different sizes also.
A simple method to solve this problem is to run three nested loops. The outermost loop picks an element from list a, 
the middle loop picks an element from b and the innermost loop picks from c. The innermost loop also checks whether the sum of values 
of current nodes of a, b and c is equal to given number. The time complexity of this method will be O(n^3).
Sorting can be used to reduce the time complexity to O(n*n). Following are the detailed steps.
1) Sort list b in ascending order, and list c in descending order.
2) After the b and c are sorted, one by one pick an element from list a and find the pair by traversing both b and c. 
*/

public class FindATripletFromThreeLinkedListsWithSumEqualToAGivenNumber
{
    
    public static void findTriplets(Linked_List l1,Linked_List l2,Linked_List l3,int key)
    {
        Node head1=l1.head;
        Node tempHead3=Util.reverse(l3.head);
        //Util.printFromNode(tempHead3);
        while(head1!=null)
        {
            Node head3=tempHead3;
            Node head2=l2.head;
            while(head2!=null&&head3!=null)
            {
                int sum=head1.data+head2.data+head3.data;
                if(sum==key)
                {
                    System.out.println("Found Triplets "+ head1.data+" "+head2.data+" "+head3.data);
                    return;
                }
                else if(sum<key)
                    head2=head2.next;
                else head3=head3.next;
            }
            head1=head1.next;
        }
    }
    public static void main(String[] args)
    {
        Linked_List l1=new Linked_List();
        Linked_List l2=new Linked_List();
        Linked_List l3=new Linked_List();
        l1.addRandomN(10);l2.addRandomN(12);l3.addRandomN(13);
        MergeSortForLinkedLists.doMergeSort(l1);
        MergeSortForLinkedLists.doMergeSort(l2);
        MergeSortForLinkedLists.doMergeSort(l3);
        //l1.printNodes();l2.printNodes();l3.printNodes();
        findTriplets(l1, l2, l3, 83);
    }
}

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
Delete a given node in Linked List under given constraints
Given a Singly Linked List, write a function to delete a given node. Your function must follow following constraints:
1) It must accept pointer to the start node as first parameter and node to be deleted as second parameter i.e.,
pointer to head node is not global.
2) It should not return pointer to the head node.
3) It should not accept pointer to pointer to head node.

You may assume that the Linked List never becomes empty.


*/

/*
PLEASE SEE THE C CODE IMPLEMENTED IN DIRECTORY GeeksForGeekC_CPP
*/

public class DeleteAGivenNodeInLinkedListUnderGivenConstraints 
{
   public native void DeleteUnderConstarints();
    static
    {
        System.load("/Users/ashutosh/NetBeansProjects/GfG/GeeksForGeekC_CPP/dist/Debug/GNU-MacOSX/libGeeksForGeekC_CPP.dylib");
    }
    public static void main(String[] args)
    {
        new DeleteAGivenNodeInLinkedListUnderGivenConstraints().DeleteUnderConstarints();
    }
}

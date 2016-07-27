/*
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
 */
package linkedlist;

/*
 *
 *@author ashutosh
 */

/*
Convert a given Binary Tree to Doubly Linked List | Set 4
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. 
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) 
must be head node of the DLL.
*/
public class BinaryTree2DLL
{
    static DoublyNode prev=null;
    static DoublyNode head_ref;
    /*COPIED FROM GEEKS FOR GEEKS*/
    public static DoublyNode binaryTree2DLLM1(DoublyNode root,DoublyLinkedList list)
    {
        if(root==null)
            return null;
        DoublyNode left=binaryTree2DLLM1(root.left, list);
        if(left!=null)
            list.addAtLast(left.data);
        DoublyNode right=binaryTree2DLLM1(root.right, list);
        if(right!=null)
            list.addAtLast(right.data);
        return root;
    }
    public static void binaryTree2DLLM3(DoublyNode root)
    {
        if(root==null)
		return;
	binaryTree2DLLM3(root.left);
	if(prev==null)
	{
		head_ref=root;
	}
	else
	{
		root.left=prev;
		prev.right=root;
	}
	prev=root;
	binaryTree2DLLM3(root.right);
    }
    public static void main(String[] args)
    {
        /*head_ref=new DoublyNode(0);
        DoublyNode root        = new DoublyNode(10);
        root.left        = new DoublyNode(12);
        root.right       = new DoublyNode(15);
        root.left.left  = new DoublyNode(25);
        root.left.right = new DoublyNode(30);
        root.right.left = new DoublyNode(36);
        binaryTree2DLLM3(root);
        while(head_ref!=null)
        {
            System.out.println(head_ref.data);
            head_ref=head_ref.right;
        }*/
        DoublyLinkedList dll=new DoublyLinkedList();
        DoublyNode root        = new DoublyNode(10);
        root.left        = new DoublyNode(12);
        root.right       = new DoublyNode(15);
        root.left.left  = new DoublyNode(25);
        root.left.right = new DoublyNode(30);
        root.right.left = new DoublyNode(36);
        binaryTree2DLLM1(root,dll);
        dll.printList();
    }
}

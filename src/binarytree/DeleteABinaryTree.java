/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author ashutosh
 */
public class DeleteABinaryTree 
{
    public static void deletePostOrder(Node current)
    {
        if(current==null)
            return;
        deletePostOrder(current.left);
        deletePostOrder(current.right);
        current=null;
    }
}

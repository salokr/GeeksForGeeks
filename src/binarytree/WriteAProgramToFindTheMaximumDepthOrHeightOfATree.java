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
public class WriteAProgramToFindTheMaximumDepthOrHeightOfATree
{
    public int getHeight(Node root)
    {
        if(root==null)
            return 0;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        int max=left>right?left:right;
        return max+1;
    }
    
}

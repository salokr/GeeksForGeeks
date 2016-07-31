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
public class GetLevelOfANodeInABinaryTree
{
    public static int getLevel(Node current,int key,int currlevel)
    {
        if(current==null)
            return 0;
        if(current.data==key)
            return currlevel;
        int fromsubtrees=getLevel(current.left,key,currlevel+1);
        if(fromsubtrees!=0)
            return fromsubtrees;
        return getLevel(current.right, key, currlevel+1);
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
  
        /* Constructing tree given in the above figure */
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        for (int x = 1; x <= 5; x++) 
        {
            int level = getLevel(tree.root, x,1);
            if (level != 0)
                System.out.println("Level of " + x + " is "
                        + getLevel(tree.root, x,1));
            else
                System.out.println(x + " is not present in tree");
        }
    }
}

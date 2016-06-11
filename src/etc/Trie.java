/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etc;

/**
 *
 * @author ashutosh
 */
public class Trie 
{
    Node root;
    public Trie()
    {
        root=new Node();
    }
    public static void main(String[] args)
    {
        Trie t=new Trie();
        t.insertToTrie("sam");
        t.insertToTrie("am");
        t.insertToTrie("saurabh");
        t.insertToTrie("saint");
        t.insertToTrie("amature");
        t.printTrie("",t.root);
    }
    public void insertToTrie(String word)
    {
        Node temp=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(temp.branches[index]==null)
            {
                temp.branches[index]=new Node();
            }
            temp=temp.branches[i];
        }
        temp.isword=true;
    } 
    public void printTrie(String word,Node current)
    {
        if(current==null)
            System.out.println(word);
        for(int i=0;i<26;i++)
            if(current.branches[i]!=null)
            {
                printTrie(('a'+i)+"",current.branches[i]);
            }
    }
}

class Node
{
    Node branches[];
    boolean isword;
    public Node()
    {
        branches=new Node[26];
        isword=false;
    }
}

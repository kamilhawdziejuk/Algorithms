package alg.DataStructures;

import java.util.HashMap;
import java.util.Scanner;

public class Trie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Trie trie = new Trie();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
            	trie.insert(contact);
            }
            else {
            	int cnt = trie.FindAmount(contact);
            	System.out.println(cnt);
            }            	
        }
    }	

    class TrieNode {
        public TrieNode[] arr;
        char Rep; //representation
        public boolean isEnd;
        public int Cnt = 0;

        public TrieNode() {
            this.arr = new TrieNode[26];
        }	
        
        public TrieNode(Character rep) {
            this.arr = new TrieNode[26];
            Rep = rep;
            Cnt++;
        }	
    }
    
	private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }       

    public int FindAmount(String word)
    {
        TrieNode p = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'a';
                        
            if(p.arr[index]==null) {
            	return 0;
            } else {            	
                p = p.arr[index];
            }
        }
               
    	return p.Cnt;
    }
    
    public void insert(String word) {
        TrieNode p = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'a';	            
            if(p.arr[index]==null) {
                TrieNode temp = new TrieNode(c);
                p.arr[index]=temp;
                p = temp;
            } else {            	
                p = p.arr[index];
                p.Cnt++;
            }
        }
        p.isEnd=true;
    }
    
}
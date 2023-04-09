import java.util.*;

class Solution {
    static int result;
    public class Node {
        Node[] next = new Node[26];
        int cnt = 0;
        boolean isEnd = false;
    }
    
    public int solution(String[] words) {
        Node root = new Node();
        for(String word : words) {
            insertWord(root, word);
        }
        findWord(root,0);
        return result;
    }
    
    private void insertWord(Node node, String word) {
        for(char c : word.toCharArray()) {
            if(node.next[c-'a']==null) {
                node.next[c-'a']=new Node();
            }
            node = node.next[c-'a'];
            node.cnt++;
        }
        node.isEnd = true;
    }
    
    private void findWord(Node node, int count) {
        if(node.cnt==1) {
            result+=count;
            return;
        }
        if(node.isEnd) {
            result+=count;
        }
        for(int i=0;i<26;i++) {
            if(node.next[i]!=null) {
                findWord(node.next[i],count+1);
            }
        }
    }

}
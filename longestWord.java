// Time Complexity :O(nl) n is the number of words and l is the length of the words;
// Space Complexity :O(l) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TrieNode root;
    class TrieNode{
        String word;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode [26];
        } 
    }
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String s: words){
            insert(s);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i>=0;i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
            
        }
        return curr.word;
    }
}
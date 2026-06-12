class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd = false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isWordEnd = true;
    }

    private boolean searchWord(TrieNode curr, String word, int i) {
        if (curr == null) return false;
        if (i >= word.length()) return curr.isWordEnd;
        char c = word.charAt(i);

        if (c == '.') {
            for (int id = 0; id < 26; id++) {
                boolean res = searchWord(curr.children[id], word, i+1);
                if (res) return res;
            }
            return false;
        }

        if (curr.children[c - 'a'] == null) return false;
        return searchWord(curr.children[c - 'a'], word, i+1);
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return searchWord(curr, word, 0);

    }
}

class Solution {
    public String foreignDictionary(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<Integer>());
        Set<Integer> wordset = new HashSet<>();

        //   fill in the graph
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i-1];
            String w2 = words[i];

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 == c2) continue;
                else {
                wordset.add(c1-'a');
                wordset.add(c2-'a');
                    adj.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }

        // now do the toposort for these elements
        int[] indeg = new int[26];
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (List<Integer> l: adj) {
            for (int ele:  l) {
                indeg[ele]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        String ans = "";
        while (!q.isEmpty()) {
            int top = q.poll();
            if (wordset.contains(top)) {
                ans += (char)(top + 'a');

                for (int nei: adj.get(top)) {
                    indeg[nei]--;
                    if (indeg[nei] == 0) q.offer(nei);
                }
            }
        }
        return ans;
    }
}

class Solution {
    private boolean isPossible(String s, int i, String cur, int[] dp, Set<String> st){
        if (i == s.length()) {
            return s.contains(cur) || cur.equals("");
        }

        if (dp[i] != -1) return dp[i] == 1;
        boolean takethis = s.contains(cur) && isPossible(s, i+1, "", dp, st);
        boolean takeNext = isPossible(s, i+1, cur + s.charAt(i), dp, st);

        dp[i] = (takeNext || takethis) ? 1 : 0;
        return (takeNext || takethis);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();
        for (String w: wordDict) st.add(w);

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);

        return isPossible(s, 0, "", dp, st);
    }
}

class Solution {
    private boolean dfs(String s, Set<String> wordSet, int i, int[] dp) {
        if (i == s.length()) return true;

        if (dp[i] != -1) return dp[i] == 1;
        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j+1))) {
                if (dfs(s, wordSet, j+1, dp)){
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word: wordDict) wordSet.add(word);

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, wordSet, 0, dp);
    }
}

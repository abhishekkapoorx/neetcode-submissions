class Solution {
    private int findMaxLen(String t1, String t2, int i, int j, int[][] dp) {
        if (i == t1.length() || j == t2.length()) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        if (t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = 1 + findMaxLen(t1, t2, i+1, j+1, dp);
        }
        return dp[i][j] = Math.max(
            findMaxLen(t1, t2, i+1, j, dp),
            findMaxLen(t1, t2, i, j+1, dp)
        );
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2)) return text1.length();

        int dp[][] = new int[text1.length()][text2.length()];
        for (int[] d: dp) Arrays.fill(d, -1);

        return findMaxLen(text1, text2, 0, 0, dp);
    }
}

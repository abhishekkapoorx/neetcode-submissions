class Solution {
    private int decode(String s, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];
        int takeOne = s.charAt(i) != 0 ? decode(s, i+1, dp) : 0;
        int takeTwo = 0;
        if (
            s.charAt(i) != '0' && 
            s.length() - i >= 2 && 
            Integer.parseInt(s.substring(i, i+1)) <= 26
        ) {
            takeTwo = decode(s, i+2, dp);
        }
        return dp[i] = takeOne + takeTwo;
    }
    public int numDecodings(String s) {
        if (s.length() == 1) return 1;

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);

        int ways = decode(s, 0, dp);
        return ways;
    }
}

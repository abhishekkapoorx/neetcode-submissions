class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return n+1;

        int w1 = Math.max(0, climbStairs(n-1));
        int w2 = Math.max(0, climbStairs(n-2));

        return w1 + w2;

    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        // char, freq;
        HashMap<Character, Integer> hmap= new HashMap<>();
        int l = 0, maxFreq = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, hmap.get(s.charAt(r)));

            while ((r - l + 1) - maxFreq > k) {
                hmap.put(s.charAt(l), hmap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

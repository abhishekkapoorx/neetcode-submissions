class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int maxLen = 0;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hmap.containsKey(c)){
                int idxFound = hmap.remove(c);
                while (j <= idxFound){
                    hmap.remove(s.charAt(j));
                    j++;
                }
                cnt = i - j ;
            }

            hmap.put(c, i);
            cnt++;
            maxLen = Math.max(maxLen, cnt);
        }
        return maxLen;
    }
}

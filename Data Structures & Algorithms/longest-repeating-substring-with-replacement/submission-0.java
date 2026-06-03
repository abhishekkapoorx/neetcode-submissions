class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0; 
        int replacedCurrently = 0;
        
        // 
        int i = 0, j = 0, change = -1;
        char curr = s.charAt(0);
        while (i < s.length()) {
            if (s.charAt(i) != curr && replacedCurrently < k){
                if (change == -1) change = i;
                replacedCurrently++;
            } 
            else if (s.charAt(i) != curr && replacedCurrently >= k) {
                j = change;
                i = change;
                curr = s.charAt(change);
                // reset things
                change = -1;
                replacedCurrently = 0;
            }
            maxLen = Math.max(maxLen, i - j + 1);
            i++;
        }
        return maxLen;
    }
}

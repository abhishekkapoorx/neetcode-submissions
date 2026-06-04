class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> t1chars = new HashMap<>();
        HashMap<Character, Integer> t2chars = new HashMap<>();

        // fill in the t1 set
        for (char c: t.toCharArray()){
            t1chars.put(c, t1chars.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        String ans = "";
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (t1chars.containsKey(c)) {
                int currfreq = t1chars.get(s.charAt(r));
                t1chars.put(c, currfreq - 1);
                t2chars.put(c, t2chars.getOrDefault(c, 0) + 1);
                if (t1chars.get(c) == 0) {
                    t1chars.remove(c);
                }
            }

            while (t1chars.isEmpty()) {
                if (ans == "" || ans.length() > (r-l+1)){
                    ans = s.substring(l, r+1);
                }
                if (t2chars.containsKey(s.charAt(l))){
                    t1chars.put(s.charAt(l), t1chars.getOrDefault(s.charAt(l), 0) + 1);
                    t2chars.put(s.charAt(l), t2chars.get(s.charAt(l)) - 1);
                }
                l++;
            }
        }
        return ans;

    }
}

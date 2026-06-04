class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> t1chars = new HashMap<>();
        HashMap<Character, Integer> t2chars = new HashMap<>();

        // fill in the t1 set
        for (char c: t.toCharArray()){
            t1chars.put(c, t1chars.getOrDefault(c, 0) + 1);
        }

        int required = t1chars.size();
        int formed = 0;

        int l = 0;
        String ans = "";
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (t1chars.containsKey(c)) {
                t2chars.put(c, t2chars.getOrDefault(c, 0) + 1);
                if (t2chars.get(c).equals(t1chars.get(c))) {
                    formed++;
                }
            }

            while (formed == required) {
                if (ans == "" || ans.length() > (r-l+1)){
                    ans = s.substring(l, r+1);
                }
                char leftChar = s.charAt(l);
                if (t1chars.containsKey(leftChar)){
                    if (t2chars.get(leftChar).equals(t1chars.get(leftChar))) {
                        formed--;
                    }
                    t2chars.put(leftChar, t2chars.get(leftChar) - 1);
                }
                l++;
            }
        }
        return ans;

    }
}
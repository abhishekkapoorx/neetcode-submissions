class Solution {
    public boolean isAnagram(String s, String t) {
        // Solution 1
        // early return if the lengths are not same
        // if (s.length() != t.length()) return false;

        // HashMap<Character, Integer> smp = new HashMap<>();
        // HashMap<Character, Integer> tmp = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     smp.put(s.charAt(i), smp.getOrDefault(s.charAt(i), 0)+1);
        //     tmp.put(t.charAt(i), tmp.getOrDefault(t.charAt(i), 0)+1);
        // }

        // for (Map.Entry<Character, Integer> e: smp.entrySet()){
        //     if (!e.getValue().equals(tmp.getOrDefault(e.getKey(), 0))) return false;
        // }
        // return true;

        // Solution 2
        if (s.length() != t.length()) return false;
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        for (int i = 0; i < s_chars.length; i++) {
            if (s_chars[i] != t_chars[i]) return false;
        }
        return true;
    }
}

class Solution {
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            s_map.put(schar, s_map.getOrDefault(schar, 0) + 1);
            t_map.put(tchar, t_map.getOrDefault(tchar, 0) + 1);
        }
        return s_map.equals(t_map);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] gp = new boolean[strs.length];
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < strs.length; i++){
            List<String> gp_ans = new ArrayList<>();
            if (gp[i]) continue;
            for (int j = i; j < strs.length; j++){
                if (isAnagram(strs[i], strs[j])) {
                    gp[j] = true;
                    gp_ans.add(strs[j]);
                }
            }
            ans.add(gp_ans);
        }
        return ans;
    }
}

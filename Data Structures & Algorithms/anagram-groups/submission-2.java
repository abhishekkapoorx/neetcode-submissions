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

    private HashMap<Character, Integer> findFreq(String s) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            s_map.put(schar, s_map.getOrDefault(schar, 0) + 1);
        }
        return s_map;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<HashMap<Character, Integer>> mapList = new ArrayList<>();

        // sort with length so we can break when len changes
        Arrays.sort(strs);
        // calculate the freq once for all the strings to use in future
        for (String s: strs) mapList.add(findFreq(s));
        // create the bool vis to not traverse when already visited
        boolean[] vis = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            // continue if already visited
            if (vis[i]) continue;

            List<String> gp = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                // break when length changes
                if (strs[i].length() != strs[j].length()) break;
                if (mapList.get(i).equals(mapList.get(j))) {
                    vis[j] = true;
                    gp.add(strs[j]);
                }
            }
            ans.add(gp);
        }
        return ans;
    }
}

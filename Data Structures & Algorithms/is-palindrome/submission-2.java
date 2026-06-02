class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            while (i < s.length()-1 && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (j > 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i>j) return true;
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}

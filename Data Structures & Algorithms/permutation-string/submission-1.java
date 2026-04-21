class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] charCountS1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCountS1[s1.charAt(i) - 'a']++;
        }
        int charCountS2[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCountS2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(charCountS1, charCountS2)) {
                return true;
            }
            charCountS2[s2.charAt(i) - 'a']++;
            charCountS2[s2.charAt(i - s1.length()) - 'a']--;
        }
        if (Arrays.equals(charCountS1, charCountS2)) {
            return true;
        }
        return false;
    }
}

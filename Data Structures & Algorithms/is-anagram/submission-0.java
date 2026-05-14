class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqArrayS = new int[26];
        for (char c: s.toCharArray()) {
            freqArrayS[c - 'a']++;
        }
        int[] freqArrayT = new int[26];
        for (char c: t.toCharArray()) {
            freqArrayT[c - 'a']++;
        }
        return Arrays.equals(freqArrayS, freqArrayT);
    }
}

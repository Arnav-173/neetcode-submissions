class Solution {
    List<String> result = new ArrayList<>();
    Map<Character, String> charMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        charMap.put('2', "abc");
        charMap.put('3', "def");
        charMap.put('4', "ghi");
        charMap.put('5', "jkl");
        charMap.put('6', "mno");
        charMap.put('7', "pqrs");
        charMap.put('8', "tuv");
        charMap.put('9', "wxyz");
        int i = 0;
        StringBuilder sb = new StringBuilder();
        backtrack(i, sb, digits);
        return result;
    }

    private void backtrack(int i, StringBuilder sb, String digits) {
        if (i >= digits.length()) {
            String str = sb.toString();
            if (!(str.isBlank() || str.isEmpty()))
                result.add(str);
            return;
        }
        Character digit = digits.charAt(i);
        String cMap = charMap.get(digit);
        char[] cMapArr = cMap.toCharArray();
        for (int j = 0; j < cMapArr.length; j++) {
            /*include the char at j in the substring */
            sb.append(cMapArr[j]);
            backtrack(i + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

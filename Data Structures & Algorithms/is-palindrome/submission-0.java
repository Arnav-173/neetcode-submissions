class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack();
        char[] charArr = s.toCharArray();
        List<Character> finalList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (isAsciiAlphanumeric(charArr[i])) {
                stack.push(charArr[i]);
                finalList.add(charArr[i]);
            }
        }
        int i = 0;
        while (!stack.isEmpty()) {
            char c = Character.toLowerCase(stack.pop());
            char a = Character.toLowerCase(finalList.get(i++));
            if (a != c) {
                return false;
            }
        }
        return true;
    }

    public boolean isAsciiAlphanumeric(char ch) {
        return  (ch >= 'a' && ch <= 'z') || 
                (ch >= 'A' && ch <= 'Z') || 
                (ch >= '0' && ch <= '9');
    }
}

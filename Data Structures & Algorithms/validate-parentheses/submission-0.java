class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        boolean result = false;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charStack.isEmpty()) {
                charStack.push(charArr[i]);
            } else {
                switch (charArr[i]) {
                    case ')':
                        if (charStack.peek() == '(') {
                            charStack.pop();
                        } else {
                            charStack.push(charArr[i]);
                        }
                        break;
                    case '}':
                        if (charStack.peek() == '{') {
                            charStack.pop();
                        } else {
                            charStack.push(charArr[i]);
                        }
                        break;
                    case ']':
                        if (charStack.peek() == '[') {
                            charStack.pop();
                        } else {
                            charStack.push(charArr[i]);
                        }
                        break;
                    default:
                        charStack.push(charArr[i]);
                }
            }
        }
        if (charStack.isEmpty()) {
            result = true;
        }
        return result;
    }
}

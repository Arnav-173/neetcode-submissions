class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer result;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            switch (s) {
                case "+":
                    Integer operand1 = stack.pop();
                    Integer operand2 = stack.pop();
                    stack.push(operand1 + operand2);
                    break;
                case "-":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand2 - operand1);
                    break;
                case "*":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1 * operand2);
                    break;
                case "/":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand2 / operand1);
                    break;
                default:
                    Integer value = Integer.valueOf(s);
                    stack.push(value);
                    break;
            }
        }
        return stack.pop();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        long num1Int = 0;
        long num2Int = 0;
        long multiplier = 1;
        for (int i = num1.length() - 1; i >= 0; i-- ) {
            long tempInt = Long.parseLong(String.valueOf(num1.charAt(i)));
            num1Int += tempInt * multiplier;
            multiplier = multiplier * 10;
        }
        multiplier = 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            long tempInt = Long.parseLong(String.valueOf(num2.charAt(i)));
            num2Int += tempInt * multiplier;
            multiplier = multiplier * 10;
        }
        return String.valueOf(num1Int * num2Int);
    }
}

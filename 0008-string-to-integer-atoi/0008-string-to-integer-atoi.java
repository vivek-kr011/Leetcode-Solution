class Solution {
    public int myAtoi(String s) {
        
        s = s.trim(); // ignore the leading whiteSpaces
        long num = 0;

        if(s.isEmpty()) {
            return 0;
        }

        int i = 0; 
        int sign = 1;
        int n = s.length();

        // Signedness
        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) ==  '-') ? -1 : 1;
            i++;
        }

        // convert string to integer
        while(i < n && Character.isDigit(s.charAt(i))) {
            // find number
            num = num * 10 + (s.charAt(i) - '0');

            // rounding
            if(num*sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if(num*sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign*num); // return integer value

    }
}
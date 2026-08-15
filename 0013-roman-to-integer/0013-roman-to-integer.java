class Solution {
    public int romanToInt(String s) {

        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = roman.get(s.charAt(s.length() - 1)); // last value of the string

        // start loop from the last second
        for(int i = s.length() - 2; i >= 0; i--) {
            if(roman.get(s.charAt(i)) < roman.get(s.charAt(i+1))) {
                res = res - roman.get(s.charAt(i));  // subtract the value IV -> -1 + 5 = 4
            } else { 
                res = res + roman.get(s.charAt(i));  // add the value
            }
        }

        return res;
    }

}
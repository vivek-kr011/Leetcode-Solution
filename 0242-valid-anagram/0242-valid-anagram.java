class Solution {
    public boolean isAnagram(String s, String t) {

        // frequency count approach TOTAL TC = O(N)

        int n1 = s.length();    //O(1) 
        int n2 = t.length();    //O(1)

        if(n1 != n2) return false;   //O(1)

        int[] freq = new int[26];

        for(int i = 0; i < n1; i++) {   // N TIMES 
            freq[s.charAt(i) - 'a']++;  //O(1)
            freq[t.charAt(i) - 'a']--;  //O(1)
        }

        for(int i = 0; i < 26; i++) {    //O(26) = O(1)
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
        
    }

}
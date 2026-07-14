class Solution {
  public int lengthOfLongestSubstring(String s) {

      int n = s.length();
      int left = 0, right = 0;

      HashSet<Character> set = new HashSet<>();

      int maxLength = 0;


      while (right < n) {
          if (!set.contains(s.charAt(right))) {
              set.add(s.charAt(right));
              maxLength = Math.max(maxLength, right - left + 1);
              right++;  // Expand the window
          } else {
              set.remove(s.charAt(left));
              left++;  // Shrink the window
          }
      }
      
      return maxLength;
  }
}


class Solution {
public:
   string minWindow(string s, string t) {
       int target[256] = {0};  // Character frequency in t
       for (char ch : t) {
           target[ch]++;
       }


       int n = s.length();
       int i = 0, j = 0;
       int count = 0;
       int required = t.length();
       int start = 0;
       int minLen = INT_MAX;


       while (j < n) {
           // Decrease the frequency and increase count only if character is needed
           if (target[s[j]] > 0) {
               count++;
           }
           target[s[j]]--;


           // If all required characters are in the window
           while (count == required) {
               if (minLen > j - i + 1) {
                   minLen = j - i + 1;
                   start = i;
               }


               // Restore character back to target count
               target[s[i]]++;
               // If that character is needed in t, reduce the match count
               if (target[s[i]] > 0) {
                   count--;
               }


               i++;
           }
           j++;
       }
       return (minLen == INT_MAX) ? "" : s.substr(start, minLen);
   }
};


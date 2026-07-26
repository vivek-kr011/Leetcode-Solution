class Solution {
public:

    bool isFreqSame(int freq1[], int freq2[]) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    bool checkInclusion(string s1, string s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        // Frequency of s1
        int freq[26] = {0};

        // Frequency of current window in s2
        int windFreq[26] = {0};

        // Build frequency arrays
        for (int i = 0; i < n; i++) {
            freq[s1[i] - 'a']++;
            windFreq[s2[i] - 'a']++;
        }

        // Compare first window
        if (isFreqSame(freq, windFreq)) {
            return true;
        }

        // Slide the window
        for (int i = n; i < m; i++) {

            // Remove leftmost character
            windFreq[s2[i - n] - 'a']--;

            // Add new rightmost character
            windFreq[s2[i] - 'a']++;

            // Compare frequencies
            if (isFreqSame(freq, windFreq)) {
                return true;
            }
        }

        return false;
    }
};
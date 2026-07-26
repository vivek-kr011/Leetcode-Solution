class Solution {
public:
    bool isFreqSame(int freq1[], int freq2[]) {  // 0(1);
        for(int i = 0; i < 26; i++) {
            if(freq1[i] != freq2[i]) {  // window mismatch
                return false;
            }
        }

        return true;
    }


    bool checkInclusion(string s1, string s2) {
        int freq[26] = {0};

        for(int i = 0; i < s1.length(); i++) {
            // int idx = s1[i] - 'a'; // a=0, b=1
            // freq[idx]++;

            freq[s1[i] - 'a']++;
        } 

        int windSize = s1.length();

        for(int i = 0; i < s2.length(); i++) {  // worst case TC is O(n^2)
            int windIdx = 0, idx = i; // idx denote original string index
            int windFreq[26] = {0};

            while(windIdx < windSize && idx < s2.length()) {
                windFreq[s2[idx] - 'a']++;
                windIdx++, idx++;
            }

            if(isFreqSame(freq, windFreq)) {  // found
                return true;
            }
        }

        return false;
        
    }
};
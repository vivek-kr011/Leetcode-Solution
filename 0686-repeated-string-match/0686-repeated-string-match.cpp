class Solution {
public:
    int repeatedStringMatch(string a, string b) {

        string ans = "";
        int count = 0;

        while(ans.size() < b.size()) {
            ans = ans + a;
            count++;
        } 
        if(ans.find(b) != string::npos) {
            return count;
        }

        ans += a;
        count++;

        if(ans.find(b) != string::npos) {
            return count;
        }

        return -1;
        
    }
};
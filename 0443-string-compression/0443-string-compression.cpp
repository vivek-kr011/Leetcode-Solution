class Solution {
public:
    int compress(vector<char>& chars) {
        int idx = 0;
        int n = chars.size();
        
        for(int i = 0; i < n; i++) {
            char ch = chars[i];   // current_character
            int count = 0;

            while(i < n && chars[i] == ch) {
                count++;
                i++;
            }

            if(count == 1) {
                chars[idx++] = ch;  //  char store in original index
            } else {
                chars[idx++] = ch;

                // store the count ( convert int into string)
                string str = to_string(count);  // int count convert in string

                for(char dig : str) {  // use for_each loop for each individual digit in our string
                    chars[idx++] = dig;

                }
            }

            i--; // to counter i++
        } 

        // resize string
        chars.resize(idx);
        return idx;
    }
};
class Solution {
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();
        StringBuilder ans= new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && str.length() != 0) {   
                ans.insert(0, str.toString() + " "); // insert at the beginning
                str.setLength(0);
            } 
            else if (s.charAt(i) == ' ')
            continue;
            else
            str.append(s.charAt(i));

        }
        if (str.length() != 0) {
            ans.insert(0, str.toString() + " ");
        }

        // Remove space
        return ans.toString().trim();

    }
}
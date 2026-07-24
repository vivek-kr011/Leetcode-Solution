class Solution {
    public String reverseWords(String s) {

        // String ans = "";
        StringBuilder str = new StringBuilder();
        // String str = "";
        StringBuilder ans= new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // if (s.charAt(i) == ' ' && !str.equals("")) {   
            if (s.charAt(i) == ' ' && str.length() != 0) {   
                // ans = str + " " + ans;
                ans.insert(0, str.toString() + " "); // insert at the beginning
                // str = "";
                str.setLength(0);
            } 
            else if (s.charAt(i) == ' ')
            continue;
            else
            // str += s.charAt(i);
            str.append(s.charAt(i));

        }
        // if (!str.equals(""))
        // ans = str + " " + ans;
        if (str.length() != 0) {
            ans.insert(0, str.toString() + " ");
        }

        // Remove space
        return ans.toString().trim();

    }
}
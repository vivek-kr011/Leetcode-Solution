class Solution {
    public String longestCommonPrefix(String[] strs) {

        /* If Array is empty */
        if (strs == null || strs.length == 0) {
            return "";
        }

        /* TAKE A FIRST STRING */
        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {
            /* CURRENT CHARACTER */
            char ch = first.charAt(i);

            /* COMPARE WITH OTHER STRING */
            for (int j = 1; j < strs.length; j++) {
                String current = strs[j]; // currrent char of other string

                /* IF current string is end */
                if (i == current.length()) {
                    
                    return first.substring(0, i);

                } else {

                    if (current.charAt(i) != ch) {
                        return first.substring(0, i);

                    }

                }
            }
        }

        return first;

    }
}
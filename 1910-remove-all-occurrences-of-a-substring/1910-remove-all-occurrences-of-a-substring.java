class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            sb.append(s.charAt(i));

            if (sb.length() >= part.length()) {

                boolean match = true;

                for (int j = 0; j < part.length(); j++) {

                    if (sb.charAt(sb.length() - part.length() + j) != part.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    sb.delete(sb.length() - part.length(), sb.length());
                }
            }
        }

        return sb.toString();
    }
}
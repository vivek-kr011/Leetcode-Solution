
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // HashMap to store:
        // Key   = Character frequency representation
        // Value = List of strings having the same character frequencies
        Map<String, List<String>> map = new HashMap<>();

        // Traverse every string in the given array
        for (String s : strs) {

            // Create a frequency array of size 26
            // Each index represents a lowercase English letter (a-z)
            // Initially, the frequency of every character is 0
            int[] count = new int[26];

            // Traverse each character of the current string
            for (char c : s.toCharArray()) {

                // Calculate the index of the current character
                // Example: 'a' - 'a' = 0, 'b' - 'a' = 1
                // Increase the frequency of that character by 1
                count[c - 'a']++;
            }

            // StringBuilder to convert the frequency array into a String key
            StringBuilder sb = new StringBuilder();

            // Traverse all 26 character frequencies
            for (int i : count) {

                // Append '#' as a separator between frequencies
                sb.append("#");

                // Append the current character frequency
                sb.append(i);
            }

            // Convert StringBuilder into a String
            // This String uniquely represents the character frequencies
            String key = sb.toString();

            // Check whether this frequency key already exists in the HashMap
            if (!map.containsKey(key)) {

                // If the key does not exist,
                // create a new empty list for this anagram group
                map.put(key, new ArrayList<String>());
            }

            // Get the list associated with this key
            // Add the current string to its corresponding anagram group
            map.get(key).add(s);
        }

        // map.values() returns all the grouped lists
        // Convert these values into an ArrayList and return the result
        return new ArrayList<>(map.values());
    }
}

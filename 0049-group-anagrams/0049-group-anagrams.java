class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // APPROACH 1 USING SORTING + HASHING TC = O(N*Klog(K))
        Map<String, List<String>> map = new HashMap<>(); // key = string, value = List

        for(int i = 0; i < strs.length; i++) {

            // convert string into char array
            String str = strs[i];
            char[] chars = strs[i].toCharArray();

            // Sort the character array
            Arrays.sort(chars);

            String sortedStr = new String(chars);

            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            } 
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
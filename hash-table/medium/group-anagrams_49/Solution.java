/**

 Q: What is the anaggram? I usually mix it up with polindroms.

 ["aba", "aab", "acc", "cca", "acc", "aa"]
 -> [["aba", "aab"], ["acc", "cca", "acc"], ["aa"]]

 Q: What is th output format for the task?
 Q: Does order in the result matter?
 Q: Can we have duplicates of the strings? 
 Q: smaller/uppercase?

Solutions:
1. Naive: for each element, iterate over array and check rest of strings
 O(n^2*s)
 Optimized - use a precompute hashmaps. O(n^2)

2. Hashmap: Compute hashmap with characters from the string and use it as a key
 in the umbrella hashmap. Put all strings to the list there.
 O(n*s)

 */
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            String hash = computeHash(str);
            List<String> list = map.getOrDefault(hash, new ArrayList());
            list.add(str);
            map.put(hash, list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    String computeHash(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val + "#");
        }
        return sb.toString();
    }



    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> res = new ArrayList();
    //     if (strs == null || strs.length == 0) {
    //         return res;
    //     }

    //     Map<Map<Character, Integer>, List<String>> map = new HashMap();
    //     for (String str : strs) {
    //         Map<Character, Integer> hash = computeHash(str);
    //         List<String> list = map.getOrDefault(hash, new ArrayList());
    //         list.add(str);
    //         map.put(hash, list);
    //     }
    //     for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
    //         res.add(entry.getValue());
    //     }
    //     return res;
    // }

    // private Map<Character, Integer> computeHash(String str) {
    //     Map<Character, Integer> map = new HashMap();
    //     for (char ch : str.toCharArray()) {
    //         Integer num = map.getOrDefault(ch, 0) + 1;
    //         map.put(ch, num);
    //     }
    //     return map;
    // }
}
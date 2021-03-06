package graph.hard.alien_dictionary_269;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 269. Alien Dictionary
 https://leetcode.com/problems/alien-dictionary/

 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

 Example 1:
 Input:
     [
         "wrt",
         "wrf",
         "er",
         "ett",
         "rftt"
     ]
 Output: "wertf"

 Example 2:
 Input:
     [
         "z",
         "x"
     ]
 Output: "zx"

 Example 3:
 Input:
     [
         "z",
         "x",
         "z"
     ]
 Output: ""

 Explanation: The order is invalid, so return "".

 Note:
 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.

 --------

 1. Complexity
    1.1 Time Complexity is O(|E| + |V|) for topological sort, where V is number of vertices and E is the number of edges
        O(C) for populating the graph, where C is the total number of characters
    1.2 Space Complexity is O(E + V), but since V is constant (26) and max number of edges is 26^2 - we can say the total
        complexity is constant.
 2. Approach
    2.1 As alternative to the topological sort we can do a DFS with marking visiting nodes in a separate status to define
        cycles in the graph. For the stack we use string builder and reverse it at the end.
 */

public class DFSSolution {
    class DiGraph {
        Map<Character, List<Character>> adj = new HashMap<>();

        public void addChar(char v) {
            adj.putIfAbsent(v, new ArrayList<>());
        }

        public void addOrder(char v, char u) {
            addChar(v);
            adj.get(v).add(u);
        }
    }

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        DiGraph graph = new DiGraph();
        if (!populate(words, graph)) {
            return "";
        }

        Map<Character, Integer> visited = new HashMap<>();
        for (Character ch : graph.adj.keySet()) {
            visited.put(ch, 0);
        }


        StringBuilder sb = new StringBuilder();
        for (Character ch : visited.keySet()) {
            if (visited.get(ch).equals(2)) {
                continue;
            }
            if (!dfs(ch, graph, visited, sb)) {
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(Character ch, DiGraph graph, Map<Character, Integer> visited, StringBuilder sb) {
        visited.put(ch, 1);
        for (Character child : graph.adj.get(ch)) {
            if (visited.get(child).equals(1)) {
                // cycle
                return false;
            }
            if (visited.get(child).equals(0)) {
                // not visited
                if (!dfs(child, graph, visited, sb)) {
                    return false;
                }
            }
        }
        sb.append(ch);
        visited.put(ch, 2);

        return true;
    }

    private boolean populate(String[] words, DiGraph graph) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                graph.addChar(word.charAt(j));
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            String word = words[i];

            if (prev.length() > word.length() && prev.startsWith(word)) {
                return false;
            }

            int length = Math.min(prev.length(), word.length());
            for (int j = 0; j < length; j++) {
                if (prev.charAt(j) != word.charAt(j)) {
                    graph.addOrder(prev.charAt(j), word.charAt(j));
                    break;
                }
            }
        }

        return true;
    }

}


/**

     abc
     b
     bbk
     bbz
     bo
     bp
     eaa
     eab

 1. Is it ASCII strings? only characters from a to z in smaller case?
 2. And they are sorted as strings, like a,abb,ac,b...
 3. So empty character is always on the top?
 4. Do we have duplicates?


     1. Simple case: one char, just put chars in the list
         a
         a
         b
         c
     2. More than one char - multiple lists. How to merge? Put relations in the graph and then do a topological sort.

         b,o,p
         a,b,e
         k,z
         a,b
         b
         a
         c

         b,l

 */

/**

    Q: We have only listed characters in the string?

    "MCMXCIV"
         |

    sum = 1994
    last = 1000

 */

class Solution {

    public int romanToInt(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0, k = s.length() - 1, last = 0;
        while (k >= 0) {
            char ch = s.charAt(k);
            int num = map.get(ch);
            if (num < last) {
                sum -= num;
            } else {
                sum += num;
                last = num;
            }
            k--;
        }
        return sum;
    }

    // public int romanToInt(String s) {
    //     if (s == null) {
    //         throw new IllegalArgumentException();
    //     }

    //     Map<Character, Integer> map = new HashMap();
    //     map.put('I', 1);
    //     map.put('V', 5);
    //     map.put('X', 10);
    //     map.put('L', 50);
    //     map.put('C', 100);
    //     map.put('D', 500);
    //     map.put('M', 1000);

    //     Map<Character, Set<Character>> links = new HashMap();
    //     links.put('I', new HashSet(Arrays.asList('V', 'X')));
    //     links.put('X', new HashSet(Arrays.asList('L', 'C')));
    //     links.put('C', new HashSet(Arrays.asList('D', 'M')));

    //     int sum = 0, k = 0;
    //     while (k < s.length()) {
    //         char ch = s.charAt(k);
    //         boolean next = k + 1 < s.length();

    //         Set<Character> link = links.get(ch);
    //         if (next && link != null && link.contains(s.charAt(k+ 1))) {
    //             sum += map.get(s.charAt(k+ 1)) - map.get(ch);
    //             k += 2;
    //         } else {
    //             sum += map.get(ch);    
    //             k += 1;
    //         }
    //     }
    //     return sum;
    // }
}
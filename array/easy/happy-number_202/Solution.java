/**

2 -> 4 -> 16 -> 1 + 36 -> 37 -> 9 + 49 -> 58 
-> 25 + 64 -> 89 -> 64 + 81 -> 145 -> 1 + 16 + 25 -> 42 -> 16 + 4 -> 4 -> 16 -> 1 + 36

Solution:
Use set to track cycle

 */


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }

        return (n == 1);
    }
}
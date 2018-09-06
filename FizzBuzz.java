//LeetCode 412
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            result.add(((i % 3 == 0) && i % 5 == 0) ? "FizzBuzz" : (i % 3 == 0 ? "Fizz" : (i % 5 == 0) ? "Buzz" : String.valueOf(i)));
        }
        return result;
    }
}

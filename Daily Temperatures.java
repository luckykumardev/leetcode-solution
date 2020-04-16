class Solution {
    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i])
             stack.pop();
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;

    }
}
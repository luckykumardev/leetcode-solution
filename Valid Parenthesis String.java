class Solution {

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                s1.push(i);
            } else if (c == ')') {
                if (!s1.isEmpty()) {
                    s1.pop();
                } else if(!s2.isEmpty()) {
                    s2.pop();
                } else {
                    return false;
                }
            } else if (c == '*') {
                s2.push(i);
            }
        }

        while(!s1.isEmpty() && !s2.isEmpty()) {
            Integer value = s2.pop();
            if (s1.peek() < value) {
                s1.pop();
            }
        }

        return s1.isEmpty();
    }
}
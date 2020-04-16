class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i =0; i <tokens.length; i++){
            String ss = tokens[i];
            if( ss.equals("+") || ss.equals("-") || ss.equals("*") || ss. equals("/") ){
              int a = s.pop();
              int b = s.pop();
              if(ss.equals("+")) s.push(b+a);
              if(ss.equals("-")) s.push(b-a);
              if(ss.equals("*")) s.push(b*a);
              if(ss.equals("/")) s.push(b/a);    
            }
            else
              s.push(Integer.parseInt(ss));
        }
        
        return s.pop();
    }
}
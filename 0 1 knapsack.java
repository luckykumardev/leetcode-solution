public static int knapsack(int weights[], int values[], int maxWeight){
    HashMap<String, Integer> mhm = new HashMap<>();
    return knapsack(weights, values, maxWeight, 0, mhm);    
}

public static int knapsack(int weights[], int values[], int maxWeight, int i, HashMap<String, Integer> mhm ){
      if(i ==  weights.length || maxWeight == 0){
        return  0;
      }

      String key = maxWeight + "#" + i;
      if(mhm.containsKey(key)){
          return mhm.get(key);
      }

      if(weights[i]  > maxWeight){
          return knapsack(weights, values, maxWeight, i+1, mhm);
      } else {
          //include the ith item
          int op1 = values[i] + knapsack(weights, values, maxWeight -weights[i], i+1, mhm);
          // don't include
          int op2 =  knapsack(weights, values, maxWeight, i+1, mhm);
          
          mhm.put(key,Math.max(op1, op2));
          return Math.max(op1, op2);
      }
}
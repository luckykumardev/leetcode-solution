public class MapNode<k, v>{
    k key;
    v value;
    MapNode<k, v> next;
     public MapNode(k key, v, value){
         this.key = key;
         this.value = value;
     }
}

public class Map<k, v>{
 ArrayList<MapNode<k, v>> buckets;
 int size;
 int numBuckets;
 public Map(){
     numBuckets =20;
     buckets = new ArrayList<>();
     for(int i =0; i <numBuckets; i++)
     buckets.add(null);
 }

 
 public int hashFunction(k key){
     int hashCode = key.hashCode();
     return hashCode%numBuckets;
 }

 public void put(k key, v value){
   int bucketIndex = hashFunction(key);
   MapNode<k, V> head = buckets.get(bucketIndex);
    while(head !=null){
        if(head.key.equals(key)){
            head.value = value;
            return;
        }
        head = head.next;
    }
     size++;
    head = buckets.get(bucketIndex);
    MapNode<k, v> newNode = new MapNode<k, v>(key, value);
    newNode.next = head;
    buckets.set(bucketIndex, newNode);
 
 }

 public int size(){
     return size;
 }


 public V getValue(k key){
   int bucketIndex = hashFunction(key);
   MapNode<k, V> head = buckets.get(bucketIndex);
    while(head !=null){
        if(head.key.equals(key)){
            return head.value;
        }
        head = head.next;
    }
     return null;
 }


 public v removeKey(k key){
   int bucketIndex = hashFunction(key);
   MapNode<k, V> head = buckets.get(bucketIndex);
   MapNode<k, V> prev = null;
    while(head !=null){
        if(head.key.equals(key)){
             if(prev == null){
                 bucket.set(bucketIndex, head.next);
             }else{
               prev.next = head.next;
             }
            size--; 
            return head.value;
        }
        head = head.next;
    }

     return null;
 }

}
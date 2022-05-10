import java.util.NoSuchElementException;

public class MyHashTable <K,V>{
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public int size() {
        return size;
    }

    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + '}';
        }
    }


    public MyHashTable(){
        this(11);
    }

    public MyHashTable(int M){
        this.M = size;
        chainArray = new HashNode[M];
        this.size = 0;
    }


    private int hash(K key){
        return key.toString().length() % chainArray.length;
    }


    public V remove(K key) {
        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        HashNode previous = null;
        while(head!= null){
            if(head.key.equals(key)){
                break; // while loop break
            }
            previous = head;
            head = head.next;
        }
        if(head == null){return null;}
        size--;
        if(previous != null){
            previous.next = head.next;
        }
        else{
            chainArray[hashedKey] = head.next;
        }
        return (V) head.value;
    }


    public void put(K key, V value){
        if(key == null || value == null){throw new NoSuchElementException("wrong");}

        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[hashedKey];
        HashNode employee = new HashNode(key,value);
        employee.next = head;
        chainArray[hashedKey] = employee;
    }


    public V get(K key){
        if(key == null){throw new IllegalArgumentException("Key is null");}

        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        while(head != null) {
            if (head.key.equals(key)) {
                System.out.println(head.value);
            }
            head = head.next;
        }
        return null;
    }


    public void getKey(V value){
        if(value == null){throw new IllegalArgumentException("Value is null");}

        int hashedValue = hash((K) value);
        HashNode head = chainArray[hashedValue];
        while(head != null){
            if(head.value.equals(value)){
                System.out.println(head.key);
            }
            head = head.next;
        }
    }


    public boolean contains(V value){
        return contains(value);
    }
}

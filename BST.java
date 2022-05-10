import org.w3c.dom.Node;

public class BST <K extends Comparable<K> ,V>{

    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }


    private Node put(Node root, K key, V value){
        if (root == null){
            root = new Node(key, value);
            return root;
        }
        if (key.compareTo(root.key) < 0){
            root.left = put(root.left, key, value);
        }
        else{
            root.right = put(root.right, key, value);
        }
        return root;
    }


    public V get(K key){
        return get(root, key);
    }

    private V get(Node root, K key){
        if (root == null){
            return null;
        }
        if (root.key.compareTo(key) == 0){
            return root.value;
        }
        if (root.key.compareTo(key) > 0) return get(root.left, key);
        return get(root.right, key);
    }

    public void delete(K key){
        delete(root, key);
    }

    private Node delete(Node root, K key){
        if (root == null) return root;

        if (key.compareTo(root.key) < 0){
            root.left = delete(root.left, key);
        }
        else if (key.compareTo(root.key) > 0){
            root.right = delete(root.right, key);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    public Iterable<K> iterator(){
        return null;
    }

}
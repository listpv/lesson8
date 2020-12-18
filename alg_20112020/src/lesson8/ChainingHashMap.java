package lesson8;

import java.util.LinkedList;

public class ChainingHashMap<Key, Value> {
    private int capacity = 7;
    private int size;

    private LinkedList<Node>[] st;

    public ChainingHashMap() {
        st = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean delete(Key key){

        checkKeyNotNull(key);
        int i = hash(key);
        for(Node node : st[i]){
            if(key.equals(node.key)){
                size--;
                return  st[i].remove(node);
            }
        }
        return false;
    }

    public Node deleteAndNode(Key key){

        checkKeyNotNull(key);
        int i = hash(key);
        for(Node node : st[i]){
            if(key.equals(node.key)){
                Node temp = node;
                st[i].remove(node);
                size--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key).append(" ");
//                sb.append(node).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

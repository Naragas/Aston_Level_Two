package main.java.task1;

import java.util.Arrays;
import java.util.Objects;

/**
 * @version 1.0
 * @autor Naragas
 * @created 7/19/2025
 */

public class CustomHashMap<K, V> {

    private final int INITIAL_CAPACITY = 16;
    private final float LOAD_FACTOR = 0.75f;
    private int size;
    private Node<K, V>[] elements;

    public CustomHashMap() {
        elements = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
        size = 0;
    }

    static class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void put(K key, V value) {

        if (size >= elements.length * LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(key);
        Node<K, V> node = elements[index];

        if (node == null) {
            elements[index] = new Node<>(key, value, null);
            size++;
            return;
        }

        while(node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
            if(node.next == null) break;
            node = node.next;
        }
        node.next = new Node<>(key, value, null);
        size++;
    }


    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> tempNode = elements[index];

        while (tempNode != null) {
            if (Objects.equals(tempNode.key, key)) {
                return tempNode.value;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    public void remove(K key) {

        int index = getIndex(key);

        Node<K, V> currentNode = elements[index];
        Node<K, V> previousNode = null;

        while (currentNode != null) {
            if (Objects.equals(currentNode.key, key)) {
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                } else {
                    elements[index] = currentNode.next;
                }
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    private int getIndex(K key) {
        return (key == null) ? 0 : key.hashCode() % elements.length;
    }

    private void resize() {
        Node<K, V>[] oldElements = elements;
        elements = (Node<K, V>[]) new Node[elements.length * 2];
        size = 0;

        for(Node<K, V> node : oldElements) {
            while(node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    @Override
    public String toString() {
        return "CustomHashMap{" +
                "INITIAL_CAPACITY=" + INITIAL_CAPACITY +
                ", LOAD_FACTOR=" + LOAD_FACTOR +
                ", size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}

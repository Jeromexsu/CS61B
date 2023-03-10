public class LinkedListDeque<T> {

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node();
        this.sentinel.item = null;
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }

    public void addFirst(T item) {
        Node node = new Node(item, this.sentinel.next, this.sentinel);
        this.sentinel.next.prev = node;
        this.sentinel.next = node;
        this.size++;
    }
    public void addLast(T item) {
        Node node = new Node(item, this.sentinel, this.sentinel.prev);
        this.sentinel.prev.next = node;
        this.sentinel.prev = node;
        this.size++;
    }

    public T removeFirst() {
        if(this.size == 0) return null;
        Node node = this.sentinel.next;
        node.next.prev = this.sentinel;
        this.sentinel.next = node.next;
        this.size--;
        return node.item;
    }
    public T removeLast() {
        if(this.size == 0) return null;
        Node node = this.sentinel.prev;
        node.prev.next = this.sentinel;
        this.sentinel.prev = node.prev;
        this.size--;
        return node.item;
    }
    public T get(int index) {
        Node ptr = this.sentinel.next;
        int i = 0;
        while(i != index) {
            ptr = ptr.next;
            i++;
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        return this.getRecursive(this.sentinel.next,index);
    }

    private T getRecursive(Node node , int index) {
        if(index == 0) return node.item;
        else return getRecursive(node.next ,index-1);
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        Node ptr = this.sentinel.next;
        while(ptr != this.sentinel) {
            System.out.print(ptr.item+" ");
            ptr = ptr.next;
        }
    }

    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node() {
        }

        public Node(T item , Node next , Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<String> test = new LinkedListDeque<>();
        test.addFirst("front");
        test.addLast("back");
        test.printDeque();
    }
}

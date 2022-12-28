public class ArrayDeque<T> {
    private final static int INIT_SIZE = 2;
    private T[] items;
    private int nextHead;
    private int nextTail;

    public ArrayDeque() {
        items = (T[]) new Object[INIT_SIZE];
        nextHead = 0;
        nextTail = 1;
    }

    public void addFirst(T item) {
        if(isFull()) resize(2);
        items[nextHead] = item;
        if(--nextHead < 0) nextHead += items.length;
    }
    public void addLast(T item) {
        if (isFull()) resize(2);
        items[nextTail] = item;
        if(++nextTail >= items.length) nextTail -= items.length;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        if (++nextHead >= items.length) nextHead -= items.length;
        T result = items[nextHead];
        items[nextHead] = null;
        return result;
    }
    public T removeLast() {
        if(isEmpty()) return null;
        if(--nextTail < 0) nextTail += items.length;
        T result = items[nextTail];
        items[nextTail] = null;
        return result;
    }

    public T get(int index) {
        // boundary check
        if(index < 0 || index > size()) return null;
        int head = (nextHead+1) % items.length;
        index += head;
        return items[index];
    }

    public boolean isEmpty(){
        int head = nextHead+1;
        if(head > items.length) head -= items.length;
        return items[head] == null;
    }
    public boolean isFull() {
        return items[nextHead] != null;
    }

    public int size(){
        if(isFull()) return items.length;
        int size = nextTail-nextHead-1;
        if (size < 0) size += items.length;
        return size;
    }
    public void printDeque(){
        if(isEmpty()) System.out.println("");
        else {
            int head = (nextHead+1) % items.length;
            int tail = (nextTail-1+ items.length) % items.length;
            if(head <= tail) {
                for(int i = head; i <= tail; i++) {
                    System.out.print(items[i]+" ");
                }
            } else {
                for(int i = head; i < items.length; i++) {
                    System.out.print(items[i]+" ");
                }
                for(int i = 0; i <= tail; i++) {
                    System.out.print(items[i]+" ");
                }
            }
        }
    }

    private void resize(int factor) {
        T[] items = (T[]) new Object[this.items.length*factor];
        int head = (nextHead+1) % items.length;
        int tail = (nextTail-1+ items.length) % items.length;
        if(head <= tail) {
            for(int i = head; i <= tail; i++) {
                items[i] = this.items[i];
            }
        } else {
            int ptr = head;
            for(int i = head; i < this.items.length; i++) {
                items[ptr++] = this.items[i];
            }
            for(int i = 0; i <= tail; i++) {
                items[ptr++] = this.items[i];
            }
        }
        this.nextTail += this.items.length;
        this.items = items;
    }

//    public static void main(String[] args) {
//        ArrayDeque<String> test = new ArrayDeque<>();
//        test.addLast("a");
//        test.addLast("b");
//        test.addLast("c");
//        test.addLast("c");
//        test.printDeque();
//        System.out.println(test.get(1));
//    }
}


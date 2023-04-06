public class latihan2NoLibrary {
    public void queueEx() {
        Queue queue = new Queue();
        queue.add("Java");
        queue.add("DotNet");
        queue.offer("PHP");
        queue.offer("HTML");
        System.out.println("remove : " + queue.remove());
        System.out.println("element : " + queue.element());
        System.out.println("poll : " + queue.poll());
        System.out.println("peek : " + queue.peek());
    }

    public static void main(String[] args) {
        new latihan2NoLibrary().queueEx();
    }
}

class Queue {
    private String[] queue;
    private int head;
    private int tail;

    public Queue() {
        queue = new String[10];
        head = 0;
        tail = -1;
    }

    public void add(String value) {
        if (tail == queue.length - 1) {
            String[] newQueue = new String[queue.length * 2];
            for (int i = head; i <= tail; i++) {
                newQueue[i - head] = queue[i];
            }
            queue = newQueue;
            tail -= head;
            head = 0;
        }
        tail++;
        queue[tail] = value;
    }

    public String remove() {
        if (isEmpty()) {
            return null;
        }
        String value = queue[head];
        head++;
        return value;
    }

    public String element() {
        if (isEmpty()) {
            return null;
        }
        return queue[head];
    }

    public boolean offer(String value) {
        add(value);
        return true;
    }

    public String poll() {
        if (isEmpty()) {
            return null;
        }
        String value = queue[head];
        head++;
        if (isEmpty()) {
            head = 0;
            tail = -1;
        }
        return value;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[head];
    }

    public boolean isEmpty() {
        return head > tail;
    }
}
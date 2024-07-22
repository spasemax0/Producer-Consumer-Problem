public class circBuffer {
    private final Double[] buffer;
    private int head;
    private int tail;
    private int count;
    private final int capacity = 1000;

    public circBuffer() {
        buffer = new Double[capacity];
        head = 0;
        tail = 0;
        count = 0;
    }

    public synchronized void add(Double item) throws InterruptedException {
        while (count == capacity) {
            wait();
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        count++;
        notify();
    }

    public synchronized Double remove() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        Double item = buffer[head];
        head = (head + 1) % capacity;
        count--;
        notify(); 
        return item;
    }

    public synchronized int getCount() {
        return count;
    }
}
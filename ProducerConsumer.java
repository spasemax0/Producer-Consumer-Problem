public class ProducerConsumer {
    public static void main(String[] args) {
        circBuffer buffer = new circBuffer();
        producer producer = new producer(buffer);
        consumer consumer = new consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Exiting!");
    }
}
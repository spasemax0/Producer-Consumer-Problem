public class consumer implements Runnable {
    private final circBuffer buffer;
    private double bufferValueCounter = 0.0;

    public consumer(circBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 1_000_000; i++) {
                Double bufferElement = buffer.remove();
                bufferValueCounter += bufferElement;
                if (i % 100_000 == 0) {
                    System.out.printf("Consumer: Consumed %d items, Cumulative value of consumed items=%.3f%n", i, bufferValueCounter);
                }
            }
            System.out.println("Consumer: Finished consuming 1,000,000 items");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
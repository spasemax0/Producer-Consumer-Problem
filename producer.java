import java.util.Random;

public class producer implements Runnable {
    private final circBuffer buffer;
    private double bufferValueCounter = 0.0;

    public producer(circBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 1; i <= 1_000_000; i++) {
                Double bufferElement = random.nextDouble() * 100.0;
                buffer.add(bufferElement);
                bufferValueCounter += bufferElement;
                if (i % 100_000 == 0) {
                    System.out.printf("Producer: Generated %d items, Cumulative value of generated items=%.3f%n", i, bufferValueCounter);
                }
            }
            System.out.println("Producer: Finished generating 1,000,000 items");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
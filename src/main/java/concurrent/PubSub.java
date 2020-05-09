package concurrent;

import java.util.*;

/**
 * Created by xufei on 2020/4/26.
 */
public class PubSub {

    public static void main(String[] args) {
        List<Consumer> consumers = new ArrayList<>();

        for (int i = 0; i < 3; i++ ) {
            Consumer consumer = new Consumer(
                    "Consumer"  + i
            );
            consumer.start();

            consumers.add(consumer);
        }

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String message = scanner.nextLine();

            for (Consumer consumer: consumers) {
                consumer.notify(message);
            }

        }
    }

    static class Consumer extends Thread {

        private Queue<String> queue;

        public Consumer(String name) {
            super(name);
            this.queue = new LinkedList<>();
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!queue.isEmpty()) {
                    String message = queue.poll();

                    System.out.println(
                            getName() + ": Consuming message: " + message
                    );
                }
            }
        }

        public void notify(String message) {
            queue.add(message);
        }
    }
}

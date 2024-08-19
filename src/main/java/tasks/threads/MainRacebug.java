package tasks.threads;

public class MainRacebug {

    static volatile int counter = 0;
    static void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Th());
        Thread thread2 = new Thread(new Th());
        thread1.start();
        thread2.start();
        thread2.join();

        System.out.println("\nFinal counter value =" + counter);
    }
}

class Th implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            MainRacebug.increment();
            System.out.print(MainRacebug.counter);
        }

    }
}

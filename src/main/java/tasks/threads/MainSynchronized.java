package tasks.threads;

public class MainSynchronized {

    static volatile int counter = 0;
    public synchronized static void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Ths());
        Thread thread2 = new Thread(new Ths());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("\nFinal counter value =" + MainSynchronized.counter);
    }
}

class Ths implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            MainSynchronized.increment();
            System.out.print(MainSynchronized.counter);
        }

    }
}

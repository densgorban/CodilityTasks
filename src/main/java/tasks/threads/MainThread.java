package tasks.threads;

import java.util.function.Supplier;

public class MainThread {



    public static void main(String[] args) throws InterruptedException {

        Thread th1 = new MyThread(0, Type.INCREMENT, 1000);
        Thread th2 = new MyThread(1000, Type.DECREMENT, 0);
        Thread th3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });

        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();
        System.out.println( Thread.currentThread().getName() + " has been completed");
    }

}

/* Stateful thread implementation*/
class MyThread extends Thread {

    private final Type type;
    private final int stopValue;
    private int i;

    public MyThread(int i, Type type, int stopValue) {
        this.i = i;
        this.type = type;
        this.stopValue = stopValue;
    }

    Supplier<Integer> increment = () -> i++;
    Supplier<Integer> decrement = () -> i--;

    @Override
    public void run() {
        int result;
        do {
            if(type == Type.INCREMENT)
                result = increment.get();
            else result = decrement.get();
            System.out.println(Thread.currentThread().getName() + ": " + result);
        } while (result != stopValue);
    }
}

enum Type {
    INCREMENT, DECREMENT
}
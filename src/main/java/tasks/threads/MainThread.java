package tasks.threads;

import java.util.function.Supplier;

public class MainThread {

    public static void main(String[] args) {

        Thread th1 = new MyThread(0, Type.INCREMENT, 1000);
        Thread th2 = new MyThread(1000, Type.DECREMENT, 0);
        System.out.println("Main thread name: " + Thread.currentThread().getName());
        th1.start();
        th2.start();
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
    INCREMENT, DECREMENT;
}
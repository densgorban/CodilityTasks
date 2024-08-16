package tasks.threads;

public class MainVolatile {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("start thread " + Thread.currentThread().getName());

        StoppableThread stoppableThread = new StoppableThread();
        stoppableThread.start();
        Thread.sleep(1000);

        stoppableThread.stopFlag =  true;

        System.out.println("end thread " + Thread.currentThread().getName());
    }

}

class StoppableThread extends Thread {

    volatile boolean stopFlag = false;
    private int count = 0;

    @Override
    public void run() {
        System.out.println("start thread " + Thread.currentThread().getName());
        while(!stopFlag) {

            System.out.println(count++);
        }
        System.out.println("end thread " + Thread.currentThread().getName());
    }
}

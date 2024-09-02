package tasks.threads;

public class MainThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Thread myInterruptedThread = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {

                System.out.println(i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted. Count " + i);
                    return;
                }
            }
            System.out.println("End of the thread "+i);
        });

        myInterruptedThread.start();

        Thread.sleep(2000);

        myInterruptedThread.interrupt();
    }

}

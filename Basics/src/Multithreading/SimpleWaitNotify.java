
// SHould use the wait and notify in the synchornized block alone
class NewThread_ extends Thread {
    private Object lock;

    NewThread_(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    void execute() {
        synchronized (lock) {
            try {

                lock.wait();
                System.out.println(Thread.currentThread().getName() + " waiting");

                System.out.println("hi");

                System.out.println(Thread.currentThread().getName() + " released");
                lock.notify();
            } catch (Exception e) {
                System.out.println("Interrupt");
            }
        }
    }

    @Override
    public void run() {
        execute();
    }
}

public class SimpleWaitNotify {
    public static void main(String[] args) {

        Object lock = new Object();

        NewThread_ thread1 = new NewThread_("Thread1", lock);
        NewThread_ thread2 = new NewThread_("Thread2", lock);
        NewThread_ thread3 = new NewThread_("Thread3", lock);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(1000); // Wait for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notify();
        }
    }
}

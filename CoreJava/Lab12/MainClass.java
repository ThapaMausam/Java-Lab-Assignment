package CoreJava.Lab12;

class ThreadA implements Runnable {
    @Override
    public void run() {
        System.out.println("\n(Thread A) All even numbers from 50 to 100: ");
        for (int i = 50; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n(Thread A) Finished.");
    }
}

class ThreadB implements Runnable {
    @Override
    public void run() {
        System.out.println("\n(Thread B) All odd numbers from 100 to 200: ");
        for (int i = 100; i <= 200; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n(Thread B) Finished.");
    }
}

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        ThreadA even = new ThreadA();
        ThreadB odd = new ThreadB();

        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println("\nMain thread has launched Thread A and Thread B.");

    }
}

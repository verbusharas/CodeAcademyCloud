package lt.verbus;

/**
 * Hello world!
 */
public class AppMultithreading01 {


    public static void main(String[] args) throws InterruptedException {

        ProgressBar progressBar = new ProgressBar();

        MyCounter counter1 = new MyCounter(1, 100, progressBar, MyCounter.Purpose.COUNTS);
        MyCounter counter2 = new MyCounter(2, 300, progressBar, MyCounter.Purpose.DISPLAYS);

        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);

        thread1.start();
        thread2.start();

    }

}

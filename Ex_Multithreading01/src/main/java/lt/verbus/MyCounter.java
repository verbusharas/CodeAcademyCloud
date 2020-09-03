package lt.verbus;

public class MyCounter implements Runnable {
    public enum Purpose {
        COUNTS, DISPLAYS;
    }

    private int threadNo;
    private int sleepInterval;
    private ProgressBar progressBar;
    private Purpose counterPurpose;


    public MyCounter(int threadNo, int sleepInterval, ProgressBar progressBar, Purpose counterPurpose) {
        this.threadNo = threadNo;
        this.sleepInterval = sleepInterval;
        this.progressBar = progressBar;
        this.counterPurpose = counterPurpose;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100 && progressBar.getProgress() < 100; i++) {
            try {
                Thread.sleep(sleepInterval);
                if (counterPurpose == Purpose.COUNTS) progressBar.increaseProgress();
                else System.out.println("Thread no. " + threadNo + "; progress: " + progressBar.getProgress());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

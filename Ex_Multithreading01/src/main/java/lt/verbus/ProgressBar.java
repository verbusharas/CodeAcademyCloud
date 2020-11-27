package lt.verbus;

public class ProgressBar {

    private int progress;

    public ProgressBar() {
        progress = 0;
    }

    public void increaseProgress(){
        progress++;
    }

    public int getProgress() {
        return progress;
    }

}

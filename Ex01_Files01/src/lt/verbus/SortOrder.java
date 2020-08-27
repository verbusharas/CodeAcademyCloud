package lt.verbus;

public enum SortOrder {
    BY_RECEIVED("-most received money-"),
    BY_SENT("-most sent money-");

    private final String successText; //verbal info about sorting order for console in case of success

    SortOrder(String successText){
        this.successText = successText;
    }

    public String getSuccessText() {
        return successText;
    }
}

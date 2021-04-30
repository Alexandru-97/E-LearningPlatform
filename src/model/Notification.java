package model;



public final class Notification {
    private final String message;
    private final String timeStamp;


    public Notification(String message, String timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;

    }

    public String getMessage() {
        return this.message;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }


}

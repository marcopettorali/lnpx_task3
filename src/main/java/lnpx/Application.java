package lnpx;

import java.util.Date;

public class Application {

    private String username;
    private String timestamp;
    private int workingGroupID;

    public Application(String username, String timestamp, int workingGroupID) {
        this.username = username;
        this.timestamp = timestamp;
        this.workingGroupID = workingGroupID;
    }

    public String getUsername() {
        return username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getWorkingGroupID() {
        return workingGroupID;
    }

}

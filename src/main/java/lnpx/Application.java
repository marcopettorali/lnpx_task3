package lnpx;

import java.util.Date;

public class Application {

    private String username;
    private Date timestamp;
    private int workingGroupID;

    public Application(String username, Date timestamp, int workingGroupID) {
        this.username = username;
        this.timestamp = timestamp;
        this.workingGroupID = workingGroupID;
    }

    public String getUsername() {
        return username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getWorkingGroupID() {
        return workingGroupID;
    }

}

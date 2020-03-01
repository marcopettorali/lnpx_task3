package lnpx;

import java.util.Date;

public class WorkingGroup {
    private int id;
    private String description;
    private String startDate;
    private String deadlineDate;
    private int usersRequired;
    private boolean completed;

    public WorkingGroup(int id, String description, String startDate, String deadlineDate, int usersRequired, boolean completed) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.usersRequired = usersRequired;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public int getUsersRequired() {
        return usersRequired;
    }

    public boolean isCompleted() {
        return completed;
    }
    
}

package mvc.model.entity;

import java.util.Date;

/**
 * Created by Denis on 26.04.2018.
 * Describes activity of time tracking system
 */
public class Activity {
    private int id;
    private String name;
    private String description;
    private Date creationDate;
    private Date deadLine;
    private int userId;
    private int time;
    private boolean addRequest;
    private boolean removeRequest;

    public Activity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isAddRequest() {
        return addRequest;
    }

    public void setAddRequest(boolean addRequest) {
        this.addRequest = addRequest;
    }

    public boolean isRemoveRequest() {
        return removeRequest;
    }

    public void setRemoveRequest(boolean removeRequest) {
        this.removeRequest = removeRequest;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
}

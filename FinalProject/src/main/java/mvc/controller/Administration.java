package mvc.controller;

import mvc.model.entity.Activity;

/**
 * Created by Denis on 26.04.2018.
 */
public interface Administration {

    Activity createActivity();

    boolean removeActivity(int activityId);

    boolean removeUser(int userId);

    void assignActivityToUser(int activityId, int userId);
}

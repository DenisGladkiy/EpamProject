package mvc.controller;

import mvc.model.entity.Activity;

/**
 * Created by Denis on 27.04.2018.
 */
public interface UserWorkflow {

    Activity proposeActivity();

    void askForRemoval(int activityId);

    void addWorkingTime(int activityId, int time);
}

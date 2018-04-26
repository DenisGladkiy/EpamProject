package mvc.controller;

import mvc.model.entity.Activity;
import mvc.model.entity.User;

/**
 * Created by Denis on 22.04.2018.
 */
public interface Controller {

    User createAccount(String login, String password);

    boolean logIn(String login, String password);

    Activity proposeActivity();

    void askForRemoval(int activityId);

    void setWorkingTime(int activityId, int time);

}

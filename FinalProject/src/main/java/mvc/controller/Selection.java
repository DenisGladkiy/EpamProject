package mvc.controller;

import mvc.model.entity.Activity;
import mvc.model.entity.User;

import java.util.List;

/**
 * Created by Denis on 26.04.2018.
 */
public interface Selection {

    List<Activity> getAllActivities();

    List<Activity> getActivitiesByUser(int userId);

    List<User> getAllUsers();
}

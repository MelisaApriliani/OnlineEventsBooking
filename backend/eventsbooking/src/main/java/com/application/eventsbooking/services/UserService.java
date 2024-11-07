package com.application.eventsbooking.services;

import com.application.eventsbooking.models.User;

public interface UserService {
     User getUserById(int id);
     User updateUser(User user);
}

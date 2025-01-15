package com.nomoreft.todoapp.user.application.usecase;

import com.nomoreft.todoapp.user.domain.User;
import com.nomoreft.todoapp.user.domain.UserName;
import com.nomoreft.todoapp.user.domain.UserProfilePicture;
import com.nomoreft.todoapp.user.domain.exception.UserProfilePictureException;

public interface _4ChangeUserProfilePicture {

    User changeBy(UserName username, UserProfilePicture profilePicture) throws UserProfilePictureException;
}

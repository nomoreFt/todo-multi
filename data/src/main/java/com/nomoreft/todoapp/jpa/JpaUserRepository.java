package com.nomoreft.todoapp.jpa;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.domain.User;
import com.nomoreft.todoapp.user.domain.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.nomoreft.todoapp.foundation.constant.ProfileConstants.*;


@Profile(PROFILE_PRODUCTION)
interface JpaUserRepository extends UserRepository, JpaRepository<User, UserId> {

}

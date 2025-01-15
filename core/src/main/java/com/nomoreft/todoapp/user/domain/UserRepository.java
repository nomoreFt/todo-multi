package com.nomoreft.todoapp.user.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(UserName username);

    User save(User user);
}

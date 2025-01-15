package com.nomoreft.todoapp;

import com.nomoreft.todoapp.foundation.crypto.PasswordEncoder;
import com.nomoreft.todoapp.user.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.nomoreft.todoapp.foundation.constant.ProfileConstants.*;

@Profile(PROFILE_DEVELOPMENT)
@Repository
class InMemoryUserRepository implements UserRepository, ApplicationRunner {

    private final UserIdGenerator userIdGenerator;
    private final PasswordEncoder passwordEncoder;

    private final List<User> users = new CopyOnWriteArrayList<>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    InMemoryUserRepository(UserIdGenerator userIdGenerator, PasswordEncoder passwordEncoder) {
        this.userIdGenerator = Objects.requireNonNull(userIdGenerator);
        this.passwordEncoder = Objects.requireNonNull(passwordEncoder);
    }

    @Override
    public Optional<User> findByUsername(UserName username) {
        return users.stream().filter(user -> Objects.equals(user.getName(), username)).findAny();
    }

    @Override
    public User save(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
        return user;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        save(new User(userIdGenerator.generateId(), UserName.of("user"), UserPassword.fromRawPassword("Password1!", passwordEncoder)));
        log.info("enroll new user (username: user, password: password)");
    }

}

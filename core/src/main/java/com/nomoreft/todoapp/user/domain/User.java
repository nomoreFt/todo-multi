package com.nomoreft.todoapp.user.domain;

import com.nomoreft.todoapp.foundation.crypto.PasswordEncoder;
import com.nomoreft.todoapp.shared.domain.DomainEntity;
import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.domain.exception.UserPasswordNotMatchedException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Entity(name = "users")
@Table(name = "todo_users")
public class User extends DomainEntity<User,UserId> implements Serializable {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private UserId id;
    @Embedded
    private UserName name;
    @Embedded
    private UserPassword password;

    @Setter
    @Embedded
    private UserProfilePicture userProfilePicture;

    public User(UserId id, UserName name, UserPassword password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * 입력된 비밀번호가 일치하는지 검증한다.
     *
     * @param rawPassword 비교할 비밀번호
     * @return 비밀번호가 일치하면 현재 사용자 객체, 그렇지 않으면 예외 발생
     */
    public User verifyPassword(String rawPassword, PasswordEncoder passwordEncoder) {
        if (this.password.matches(rawPassword, passwordEncoder)) {
            return this;
        }
        throw new UserPasswordNotMatchedException();
    }

    /**
     * 사용자 프로필 이미지를 변경한다.
     *
     * @param userProfilePicture 변경할 프로필 이미지
     * @return 프로필 이미지가 변경된 현재 사용자 객체
     */
    public User changeProfilePicture(UserProfilePicture userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
        return this;
    }

    @SuppressWarnings("unused")
    protected User() {}

    @Override
    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }
}

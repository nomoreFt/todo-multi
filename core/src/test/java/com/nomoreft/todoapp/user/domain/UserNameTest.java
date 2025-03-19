package com.nomoreft.todoapp.user.domain;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class UserNameTest {


    @Test
    void 동일한_값을_가진_객체는_동등해야_한다() {
        UserName name1 = UserName.of("Spring");
        UserName name2 = UserName.of("Spring");

        assertThat(name1).isEqualTo(name2);
        assertThat(name1.hashCode()).isEqualTo(name2.hashCode());
    }

}
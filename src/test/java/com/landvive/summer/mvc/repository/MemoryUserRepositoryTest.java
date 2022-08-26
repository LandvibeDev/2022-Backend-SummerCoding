package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryUserRepositoryTest {
    UserRepository repository = new MemoryUserRepository();

    @Test
    public void save() {
        //given 어떤 환경
        User user = new User();
        user.setName("유지수");
        user.setAccount(20000);

        //when 어떻게
        repository.save(user);
        User savedUser = repository.findById(user.getId()).get();

        //then 결과값
        Assertions.assertThat(user.getName()).isEqualTo(savedUser.getName());
    }

    @Test
    public void 유저이름_조회() {
        //given
        User user1 = new User();
        user1.setName("유지수");
        user1.setAccount(1000);
        repository.save(user1);

        User user2 = new User();
        user2.setName("강진우");
        user2.setAccount(2000);
        repository.save(user2);

        //when
        User user = repository.findByName(user2.getName()).get();

        //then
        Assertions.assertThat(user.getName()).isEqualTo(user.getName());
    }
}

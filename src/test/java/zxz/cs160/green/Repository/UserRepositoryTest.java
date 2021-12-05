package zxz.cs160.green.Repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import zxz.cs160.green.Model.User;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindAllBySQL() {
        // given
        User user = new User(
                "Lin",
                "Zhu",
                "zhulin@sjsu.edu",
                "123456",
                "ROLE_USER"
        );
        underTest.save(user);

        // when
        List<User> userList = underTest.findAllBySQL();

        // then
        assertThat(userList.size()).isEqualTo(1);
    }
}
package org.acme.getting.started.user;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class UserRepositoryTest {

  @Inject
  UserRepository userRepository;

  @Test
  void testPersist(){
    // Make sure there are no users stored
    userRepository.deleteAll();

    User user = new User();
    user.firstName = "John";
    user.lastName = "Doe";
    user.age = 20;
    userRepository.persist(user);

    Assertions.assertEquals(1, userRepository.count());
    User persistedUser = userRepository.findById(user.id);
    Assertions.assertNotNull(persistedUser);
  }
}

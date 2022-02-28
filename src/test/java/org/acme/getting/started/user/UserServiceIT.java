package org.acme.getting.started.user;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class UserServiceIT {

  @Inject
  UserService userService;

  @AfterEach
  private void removeContext(){
    userService.deleteAll();
  }

  @Test
  void testPersistUser(){
    List<User> userList = userService.listAllUsers();
    Assertions.assertTrue(userList.isEmpty());
    User user = User.builder().firstName("John").lastName("Doe").age(22).build();
    userService.persistUser(user);
    User persistedUser = userService.findUser(user);
    Assertions.assertEquals("John", persistedUser.firstName);
    Assertions.assertEquals("Doe", persistedUser.lastName);
    Assertions.assertEquals(22, persistedUser.age);
  }


  @Test
  void testPersistUsers(){
    List<User> userList = userService.listAllUsers();
    Assertions.assertTrue(userList.isEmpty());
    User user1 = User.builder().firstName("John").lastName("Doe").age(22).build();
    User user2 = User.builder().firstName("Mary").lastName("Doe").age(21).build();
    userService.persistUsers(List.of(user1, user2));
    List<User> persistedUser = userService.listAllUsers();
    Assertions.assertEquals("John", persistedUser.get(0).firstName);
    Assertions.assertEquals("Doe", persistedUser.get(0).lastName);
    Assertions.assertEquals(22, persistedUser.get(0).age);

    Assertions.assertEquals("Mary", persistedUser.get(1).firstName);
    Assertions.assertEquals("Doe", persistedUser.get(1).lastName);
    Assertions.assertEquals(21, persistedUser.get(1).age);
  }

  @Test
  void testDeleteUser(){
    List<User> userList = userService.listAllUsers();
    Assertions.assertTrue(userList.isEmpty());
    User user = User.builder().firstName("John").lastName("Doe").age(22).build();
    userService.persistUser(user);
    User persistedUser = userService.findUser(user);
    Assertions.assertEquals("John", persistedUser.firstName);
    Assertions.assertEquals("Doe", persistedUser.lastName);
    Assertions.assertEquals(22, persistedUser.age);
    userService.deleteUser(persistedUser);

    persistedUser = userService.findUser(persistedUser);
    Assertions.assertNull(persistedUser);
  }
}

package org.acme.getting.started.user;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

  @Inject
  UserRepository userRepository;

  public List<User> listAllUsers(){
    return userRepository.findAll().list();
  }

  public void persistUser(User user){
    userRepository.persist(user);
  }

  public void persistUsers(List<User> users){
    userRepository.persist(users);
  }

  public User findUser(User user) {
    return userRepository.findById(user.id);
  }

  public void deleteUser(User user) {
    userRepository.deleteById(user.id);
  }

  public void deleteAll() {
    userRepository.deleteAll();
  }
}

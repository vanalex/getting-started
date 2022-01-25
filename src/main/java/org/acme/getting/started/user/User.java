package org.acme.getting.started.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  public String id;

  @Column(name = "first_name")
  public String firstName;

  @Column(name = "last_name")
  public String lastName;

  public Integer age;
}

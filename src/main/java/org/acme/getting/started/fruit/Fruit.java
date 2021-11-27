package org.acme.getting.started.fruit;

import java.util.Objects;
import lombok.Builder;

@Builder
public class Fruit {

  private String name;
  private String description;
  private String id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Fruit)) {
      return false;
    }

    Fruit other = (Fruit) obj;

    return Objects.equals(other.name, this.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}

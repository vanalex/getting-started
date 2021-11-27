package org.acme.getting.started.fruit;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class FruitServiceTest {

  @Inject
  FruitService fruitService;

  @Test
  void test(){
    String uuid = UUID.randomUUID().toString();
    Fruit fruit = Fruit.builder()
        .description("passion fruit")
        .name("passion fruit")
        .id(uuid)
        .build();
    fruitService.add(fruit);
    List<Fruit> fruits = fruitService.list();
    Fruit saved = fruits.stream().filter(f -> fruit.equals(f)).findFirst().orElseGet(() -> Fruit.builder().build());
    Assertions.assertEquals(fruit, saved);
  }
}

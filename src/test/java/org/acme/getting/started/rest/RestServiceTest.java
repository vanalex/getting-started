package org.acme.getting.started.rest;

import io.quarkus.test.junit.QuarkusTest;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RestServiceTest {

  @Inject
  FruitService fruitService;

  @Test
  void testElasticSearch() throws IOException {
    Fruit orange = Fruit.builder()
        .color("orange")
        .name("orange")
        .build();
    fruitService.index(orange);
    Fruit saved = fruitService.get(orange.id);
    List<Fruit> fruits = fruitService.searchByColor("orange");
    Assertions.assertFalse(fruits.isEmpty());
  }
}

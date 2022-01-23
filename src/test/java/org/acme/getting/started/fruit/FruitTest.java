package org.acme.getting.started.fruit;

import io.quarkus.panache.common.Sort;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class FruitTest {

  @Test
  void testPersist(){
    String uuid = UUID.randomUUID().toString();
    Fruit fruit = Fruit.builder()
        .description("passion fruit")
        .name("passion fruit")
        .id(uuid)
        .build();
    fruit.persist();
    Uni<List<Fruit>> fruits =  Fruit.listAll(Sort.by("name"));
    Assertions.assertNotNull(fruits);

  }
}

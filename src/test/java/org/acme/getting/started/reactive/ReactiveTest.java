package org.acme.getting.started.reactive;

import io.smallrye.mutiny.Uni;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReactiveTest {

  @Test
  void testEasyReactiveTransformation() throws ExecutionException, InterruptedException {
    String result = Uni.createFrom().item("hello")
        .onItem().transform(item -> item + " mutiny")
        .onItem().transform(String::toUpperCase)
        .subscribe().asCompletionStage().get();

    Assertions.assertEquals("HELLO MUTINY", result);
  }

}

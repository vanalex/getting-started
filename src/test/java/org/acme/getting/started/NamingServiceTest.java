package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.acme.getting.started.cdi.NamingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class NamingServiceTest {

  @Inject
  Instance<NamingService> namingServices;

  @Test
  void test(){
    List<String> result = namingServices.stream().map(NamingService::name).collect(Collectors.toList());
    Assertions.assertFalse(result.isEmpty());
  }
}

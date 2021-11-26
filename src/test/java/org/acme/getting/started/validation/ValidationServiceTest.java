package org.acme.getting.started.validation;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ValidationServiceTest {

  @Inject
  BookValidationService validationService;

  @Test
  void test(){
    Book book = Book.builder().pages(0d).build();
    Set<ConstraintViolation<Book>> result = validationService.validate(book);
    Assertions.assertEquals(3, result.size());
    List<String> messages= result.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    Assertions.assertTrue(messages.contains("Author may not be blank"));
    Assertions.assertTrue(messages.contains( "Author has been very lazy"));
    Assertions.assertTrue(messages.contains("Title may not be blank"));
  }
}

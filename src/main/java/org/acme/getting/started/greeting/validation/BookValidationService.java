package org.acme.getting.started.greeting.validation;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@ApplicationScoped
public class BookValidationService implements ValidationService<Book>{

  @Inject
  Validator validator;

  @Override
  public Set<ConstraintViolation<Book>> validate(Book book) {
    return validator.validate(book);
  }
}

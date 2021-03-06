package org.acme.getting.started.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;

public interface ValidationService<T> {
  Set<ConstraintViolation<T>> validate(@Valid T t);
}

package org.acme.getting.started;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Cacheable
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit extends PanacheEntity {

    private String name;
    private String description;
}

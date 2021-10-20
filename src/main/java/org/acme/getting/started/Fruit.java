package org.acme.getting.started;

import lombok.*;

@EqualsAndHashCode
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit{

    private String name;
    private String description;
    private Long id;
}

package org.acme.getting.started;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Greeting {

    private String greet;
}

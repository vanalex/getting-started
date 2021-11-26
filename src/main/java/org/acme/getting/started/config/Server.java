package org.acme.getting.started.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "server")
public interface Server {
    String host();

    int port();

    Log log();

    interface Log {
        boolean enabled();

        String suffix();

        boolean rotate();
    }
}
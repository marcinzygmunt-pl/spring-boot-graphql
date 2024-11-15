package pl.marcinzygmunt.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    private final UUIDScalar uuidScalar;

    public GraphQLConfig(UUIDScalar uuidScalar) {
        this.uuidScalar = uuidScalar;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(uuidScalar.getUUIDScalarType());
    }
}
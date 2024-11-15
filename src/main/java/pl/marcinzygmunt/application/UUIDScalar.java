package pl.marcinzygmunt.application;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDScalar {

    public GraphQLScalarType getUUIDScalarType() {
        return GraphQLScalarType.newScalar()
                .name("UUID")
                .description("UUID scalar type")
                .coercing(new Coercing<UUID, String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) {
                        if (dataFetcherResult instanceof UUID) {
                            return dataFetcherResult.toString();
                        }
                        throw new IllegalArgumentException("Invalid UUID value: " + dataFetcherResult);
                    }

                    @Override
                    public UUID parseValue(Object input) {
                        try {
                            return UUID.fromString(input.toString());
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Invalid UUID value: " + input, e);
                        }
                    }

                    @Override
                    public UUID parseLiteral(Object input) {
                        if (input instanceof graphql.language.StringValue) {
                            return UUID.fromString(((graphql.language.StringValue) input).getValue());
                        }
                        throw new IllegalArgumentException("Expected a StringValue for UUID but got: " + input);
                    }
                })
                .build();
    }
}
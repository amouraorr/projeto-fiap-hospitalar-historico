package com.fiap.hospitalar.historico.config.graphql;

import com.fiap.hospitalar.historico.resolver.HistoryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLSchema schema() {
        return SchemaParser.newParser()
                .file("graphql/schema.graphqls")
                .resolvers((GraphQLResolver<?>) new HistoryResolver())
                .build()
                .makeExecutableSchema();
    }

}
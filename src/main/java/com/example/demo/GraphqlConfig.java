package com.example.demo;

import graphql.schema.DataFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.query.QuerydslDataFetcher;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(MyEntityRepository repository) {

        DataFetcher dataFetcher = QuerydslDataFetcher.builder(repository).projectAs(MyEntityProjection.class).many();

        return wiringBuilder -> wiringBuilder
                .type("Query", builder -> builder.dataFetcher("myEntities", dataFetcher));
    }

}

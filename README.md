# spring-graphq-no-bean-resolver

Run application

```
./gradlew bootRun
```

Open http://localhost:8080/graphiql?path=/graphql and run query

```
query {
  myEntities {
    name
  }
}
```

This returns (correctly)

```
{
  "data": {
    "myEntities": [
      {
        "name": "static value"
      }
    ]
  }
}
```

Now change `MyEntityProjection.getName()` `@Value` annotation to

```
@Value("#{@myBean.getName()}")
```
and rerun the application.

According to https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections, the value should refer to `MyBean.getName()` method.
Instead, `org.springframework.expression.spel.SpelEvaluationException: EL1057E: No bean resolver registered in the context to resolve access to bean 'myBean'`
is thrown.

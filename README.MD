# CQRS (Comand Query Responsibility Segregation)

Exemplary implementation of CQRS pattern in Java language.

## Getting Started

Module provides toolkit for usage of CQRS pattern.

### Prerequisites

* Necessary dependencies:
```
    <dependency>
        <groupId>com.wojciechwaldon</groupId>
        <artifactId>cqrs</artifactId>
    </dependency>
```

* Necessary beans located in **cqrs-infrastructure** configuration:

```
    @Configuration
    @Import(CqrsConfiguration.class)
    public class TargetConfiguration {
      ...
    }
```

* Changing used libraries versions is recommended in order to avoiding errors during runtime.

## Testing

**cqrs-application** provides tests checking implementation's correctness.

### Running tests

Running tests allows following command:

```
mvn test
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

**Wojciech Waldon** - check me on [github](https://github.com/wojciechwaldon/).

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

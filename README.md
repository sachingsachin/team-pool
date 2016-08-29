# team-pool

Run as `mvn jetty:run` and visit:

1. [http://localhost:8080/hello](http://localhost:8080/hello)
2. [http://localhost:8080/metrics](http://localhost:8080/metrics)


You can also run the war file as:
```
mvn clean package
java -jar target/dependency/jetty-runner.jar target/*.war
```

This example makes it easy to get started with Jetty based applications

# team-pool

Run as `mvn jetty:run -Djetty.port=4241` and visit:

1. [http://localhost:4241/mainpage](http://localhost:4241/mainpage)
2. [http://localhost:4241/metrics](http://localhost:4241/metrics)
3. [http://localhost:4241/test-apis](http://localhost:4241/test-apis)


You can also run the war file as:
```
mvn clean package
java -jar target/dependency/jetty-runner.jar target/*.war
```

This example makes it easy to get started with Jetty based applications

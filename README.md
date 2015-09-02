Titan - TinkerPop3 Java Example
===============================

Simple Java example showing a shortest path calculation.

https://groups.google.com/d/msg/aureliusgraphs/5ixzSuUveD4/wdWT6boZFAAJ

## Prerequisites

* Java 8.0 Update 40 or higher
* Apache Maven 3.3.x

## Building and Running

```
rm -rf ./data
mvn clean package
mvn exec:java -Dexec.mainClass="pluradj.titan.tinkerpop3.example.JavaExample"
```
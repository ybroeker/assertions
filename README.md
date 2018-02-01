[ ![Download](https://api.bintray.com/packages/ybroeker/assertions/assertions/images/download.svg) ](https://bintray.com/ybroeker/assertions/assertions/_latestVersion)

## Usage


```java
import static de.ybroeker.assertions.json.JsonAssert.*;

assertThat("{\"field\":\"value\"}").jsonPathAsString("$.field").isEqualTo("value");
```


## Dependency

Add an Repository to your Repository-Section:

```xml
<repository>
    <snapshots>
        <enabled>false</enabled>
    </snapshots>
    <id>bintray-ybroeker-natternstube</id>
    <name>bintray</name>
     <url>http://dl.bintray.com/ybroeker/natternstube</url>
</repository>
```

Add the Dependency

```xml
<dependency>
  <groupId>de.ybroeker</groupId>
  <artifactId>assertions</artifactId>
  <version>0.1</version>
  <type>pom</type>
</dependency>
```

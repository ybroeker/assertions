[ ![Download](https://api.bintray.com/packages/ybroeker/assertions/assertions/images/download.svg) ](https://bintray.com/ybroeker/assertions/assertions/_latestVersion)
[![Build Status](https://travis-ci.org/ybroeker/assertions.svg?branch=master)](https://travis-ci.org/ybroeker/assertions)
[![Maintainability](https://api.codeclimate.com/v1/badges/1f948b7bad12dbe6e093/maintainability)](https://codeclimate.com/github/ybroeker/assertions/maintainability)

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

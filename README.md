
Thymeleaf If-Not-Null Dialect
=============================

[![Build Status](https://travis-ci.org/ultraq/thymeleaf-ifnotnull-dialect.svg?branch=master)](https://travis-ci.org/ultraq/thymeleaf-ifnotnull-dialect)
[![Coverage Status](https://coveralls.io/repos/github/ultraq/thymeleaf-ifnotnull-dialect/badge.svg?branch=master)](https://coveralls.io/github/ultraq/thymeleaf-ifnotnull-dialect?branch=master)
[![GitHub Release](https://img.shields.io/github/release/ultraq/thymeleaf-ifnotnull-dialect.svg?maxAge=3600)](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.thymeleaf/thymeleaf-ifnotnull-dialect.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.thymeleaf%22%20AND%20a%3A%22thymeleaf-ifnotnull-dialect%22)
[![License](https://img.shields.io/github/license/ultraq/thymeleaf-ifnotnull-dialect.svg?maxAge=2592000)](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/blob/master/LICENSE.txt)

A dialect that outputs elements and values only if the value exist.  It's
basically a combination of `th:if` with the underlying Thymeleaf processor it
mimics, eg: `ifnotnull:text` = `th:if` + `th:text`.


Installation
------------

Minimum of Java 8 and Thymeleaf 3.0 required.  For use with older versions of
Java or Thymeleaf, check out previous releases by exploring the [releases](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/releases)
page.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-ifnotnull-dialect`
 - Version: (as per the badges above)

### Standalone distribution
Copy the JAR from [one of the release bundles](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/releases),
placing it in the classpath of your program, or build the project from the
source code here on GitHub.


Usage
-----

Add the If-Not-Null dialect to your existing Thymeleaf template engine, eg:

For those configuring their own Thymeleaf template engine:

```java
TemplateEngine templateEngine = new TemplateEngine();
templateEngine.addDialect(new IfNotNullDialect());
```

For those using Spring Boot with Java Configuration:

```java
@Bean
public IfNotNullDialect ifNotNullDialect() {
  return new IfNotNullDialect();
}
```

For those using Spring XML for configuration:

```xml
<bean id="templateEngine" class="org.thymeleaf.spring5.SpringTemplateEngine">
  <property name="additionalDialects">
    <set>
      <bean class="nz.net.ultraq.thymeleaf.ifnotnull.IfNotNullDialect"/>
    </set>
  </property>
</bean>
```

This will introduce the `ifnotnull` namepace, and some new attribute processors
that you can use in your pages, outlined below:

### src

A combination of `th:if` and `th:src`, runs the expression given to it and, if
it's not `null`, outputs the element and the result of the expression to the
`src` attribute of the element.

```html
<img ifnotnull:src="${myObject.imageUrl}"/>
```

### text

A combination of `th:if` and `th:text`, runs the expression given to it and, if
it's not `null`, outputs both the element and the result of the expression
as a text node of the element.

```html
<div ifnotnull:text="${myObject.someProperty}"></div>
```

### utext

Same as above, but prints unescaped text instead.

```html
<div ifnotnull:utext="${myObject.someProperty}"></div>
```

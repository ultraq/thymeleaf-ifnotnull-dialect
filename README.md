
Thymeleaf If-Not-Null Dialect
=============================

[![Build Status](https://travis-ci.org/ultraq/thymeleaf-ifnotnull-dialect.svg?branch=master)](https://travis-ci.org/ultraq/thymeleaf-ifnotnull-dialect)

A dialect that outputs elements and values only if the value exist.  It's
basically a combination of `th:if` with `th:text`/`th:utext`.

 - Current version: 1.0.2
 - Released: 23 April 2015


Installation
------------

Minimum of Java 7 required.

### Standalone distribution
Copy the JAR from [the latest release bundle](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/releases),
placing it in the classpath of your program, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-ifnotnull-dialect`
 - Version: `1.0.2`


Usage
-----

Add the If-Not-Null dialect to your existing Thymeleaf template engine, eg:

Java example:

```java
templateEngine.addDialect(new IfNotNullDialect());
```

Spring XML configuration example:

```xml
<bean id="templateEngine" class="org.thymeleaf.spring3.SpringTemplateEngine">
  ...
  <property name="additionalDialects">
    <set>
      <bean class="nz.net.ultraq.thymeleaf.IfNotNullDialect"/>
    </set>
  </property>
</bean>
```

This will introduce the `ifnotnull` namepace, and 2 new attribute processors
that you can use in your pages: `text`, and `utext`.

### text

A combination of `th:if` and `th:text`, runs the expression given to it and, if
it's not `null`, outputs both the element and the result of the expression
as a text node of the element.

```html
<html xmlns:ifnotnull="http://www.ultraq.net.nz/thymeleaf/ifnotnull">
  ...
  <div ifnotnull:text="${myObject.someProperty}"></div>
  ...
</html>
```

### utext

Same as above, but prints unescaped text instead.

```html
<html xmlns:ifnotnull="http://www.ultraq.net.nz/thymeleaf/ifnotnull">
  ...
  <div ifnotnull:utext="${myObject.someProperty}"></div>
  ...
</html>
```


Changelog
---------

### 1.0.2
 - Update [Thymeleaf Testing JUnit](https://github.com/ultraq/thymeleaf-testing-junit)
   bridge - initial release buggy when tests start failing!

### 1.0.1
 - Add dialect metadata file for the Eclipse plugin
 - Add tests using new [Thymeleaf Testing JUnit](https://github.com/ultraq/thymeleaf-testing-junit)
   bridge

### 1.0.0
 - Initial release



Thymeleaf If-Not-Null Dialect
=============================

[![Build Status](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/actions/workflows/build.yml/badge.svg)](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/actions)
[![Coverage Status](https://coveralls.io/repos/github/ultraq/thymeleaf-ifnotnull-dialect/badge.svg?branch=master)](https://coveralls.io/github/ultraq/thymeleaf-ifnotnull-dialect?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.thymeleaf/thymeleaf-ifnotnull-dialect.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.thymeleaf%22%20AND%20a%3A%22thymeleaf-ifnotnull-dialect%22)

A dialect that outputs elements and values only if the value exist.  It's
basically a combination of `th:if` with the underlying Thymeleaf processor it
mimics, eg: `ifnotnull:text` = `th:if` + `th:text`.


Installation
------------

Minimum of Java 8 and Thymeleaf 3.0 required.

### For Maven and Maven-compatible dependency managers

Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-ifnotnull-dialect`
 - Version: `3.0.1`

Check the [project releases](https://github.com/ultraq/thymeleaf-ifnotnull-dialect/releases)
for a list of available versions.  Each release page also includes a
downloadable JAR if you want to manually add it to your project classpath.


Usage
-----

Configure Thymeleaf to include the if-not-null dialect using one of the methods
below:

 - Spring or Spring Boot 2 w/ Java/annotation config:
   ```java
   @Bean
   public IfNotNullDialect ifNotNullDialect() {
     return new IfNotNullDialect();
   }
   ```

 - DIY management of the Thymeleaf template engine:
   ```java
   TemplateEngine templateEngine = new TemplateEngine();
   templateEngine.addDialect(new IfNotNullDialect());
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

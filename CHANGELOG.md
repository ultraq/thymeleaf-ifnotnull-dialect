
Changelog
=========

### 3.0.0
 - Minimum required Java version is now 8
 - Upgrade to Groovy 3.0.3
 - Upgrade Thymeleaf Expression Processor to 2.0.0
 - Added a `ifnotnull:src` processor

### 2.1.0
 - Use a lower level of escaping for `ifnotnull:text` for faster performance and
   to be more in line with what Thymeleaf's `th:text` processor does.
 - Extracted expression processing into a new [Thymeleaf Expression Processor](https://github.com/ultraq/thymeleaf-expression-processor)
   module

### 2.0.0
 - Dialect updated to work with Thymeleaf 3.0

### 1.0.3
 - Update [Thymeleaf Testing JUnit](https://github.com/ultraq/thymeleaf-testing-junit)
   again.
 - Just a few code style changes to be less Java, more Groovy

### 1.0.2
 - Update [Thymeleaf Testing JUnit](https://github.com/ultraq/thymeleaf-testing-junit)
   bridge - initial release buggy when tests start failing!

### 1.0.1
 - Add dialect metadata file for the Eclipse plugin
 - Add tests using new [Thymeleaf Testing JUnit](https://github.com/ultraq/thymeleaf-testing-junit)
   bridge

### 1.0.0
 - Initial release

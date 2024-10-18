## Introduction
As usual, this article begins by addressing three key questions: what, why, and how, followed by an example.
If you are a developer working on a Spring Boot application, you're likely familiar with application properties used to manage externalized settings such as environment configurations, database connections, and custom properties.
The challenge arises in how to handle or read these properties efficiently and professionally. The solution is the @ConfigurationProperties annotation, which allows developers to map external configurations directly to Java objects.
As usual, this article begins by addressing three key questions: what, why, and how, followed by an example. It explores the purpose, usage, and benefits of utilizing @ConfigurationProperties for managing application configurations. So, let's dive in!
### 1. What is @ConfigurationProperties Annotation?
   The @ConfigurationProperties annotation in Spring Boot is used to link or bind external configuration properties defined in application.properties or application.yml to a Plain Old Java Object (POJO).
   This simplifies the management of application-specific settings, ensuring a clean and organized approach.
   Key Features:
   Lets you directly map configuration values to fields in a Java object.
   Works with nested properties and complex data structures.
   Provides type safety with strong validation of properties when the application starts.

### 2. Why Use @ConfigurationProperties Annotation?
   Using @ConfigurationProperties provides several advantages:
   Application configurations are decoupled from the business logic, promoting cleaner code.
   Unlike reading configuration values directly from Environment or @Value , @ConfigurationProperties ensures that properties are bound to types correctly.
   It allows for grouping related configurations together under a specific prefix, making the properties easier to manage and understand.

### 3. How @ConfigurationProperties Works
   At its core, @ConfigurationProperties maps property values defined in the configuration file (like application.yml or application.properties) to fields in a Java class. The key aspect is that you specify a prefix for properties to be bound.
   Let's walk through an example where we use @ConfigurationProperties to load application-specific settings.
### 4. Example: Using the @ConfigurationProperties Annotation in Spring Boot
   Note:The dependencies used in this project are Spring Boot Starter Web and Lombok.
   
##### Step 1: Define Configuration Properties in application.properites file.
   In this example, we configure the name, description, and version of an application. These are the properties we want to map.
   
application.properties
```
   spring.application.name=ConfigMaster
    app.name=ConfigApp
    app.description=A site for config management
    app.version=1.0
```
##### Step 2: Create a POJO to Bind the Properties

```
package com.configmaster.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private String description;
    private String version;
}
```
In this class, the @ConfigurationProperties annotation indicates that the properties with the prefix "app" should be bound to the fields of AppProperties.

##### Step 3: Injecting the Configuration in Your Application
Now, you can inject the AppProperties class wherever it's needed. For instance, in a controller or service class, you can access the configuration values:
```
package com.configmaster.api;

import com.configmaster.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigTestApiEndPoint {
private final AppProperties appProperties;

    @Autowired
    public ConfigTestApiEndPoint(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/info")
    public String getAppInfo() {
        return "App Name: " + appProperties.getName() +
                ", Description: " + appProperties.getDescription() +
                ", Version: " + appProperties.getVersion();
    }
}
```
The @ConfigTestApiEndPoint class accesses the properties defined in AppProperties and can return them as part of a REST endpoint.

### Conclusion
The @ConfigurationProperties annotation in Spring Boot offers a powerful and flexible way to manage external configuration properties.
It promotes better separation of concerns by decoupling configuration from business logic, ensures type safety, and allows for easy validation of property values.
By leveraging this annotation, you can keep your code clean, maintainable, and scalable, making it a crucial part of modern Spring Boot applications.
For any project that requires organized management of configuration data, @ConfigurationProperties is a must-use tool!

Medium URL: `https://medium.com/@midhunbalan.dev/understanding-configurationproperties-annotation-in-springboot-674550f51f9a`

Thank you so much for reading! Feel free to leave a comment if you have any questions. Have a wonderful day!
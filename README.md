# Knowledge Book API
Knowledge API allows you to hook into the Knowledge Book Plugin that allows you to easily convert java classes into mongo documents.

## Table of Contents
1. [Installing the Knowledge Book API](#installation)
2. [What's in the Knowledge Book API](#api)
3. [Using the Knowledge Book API](#usage)
4. [Contributing to the Knowledge Book API](#contributing)
5. [Knowledge Book's License](#license)
6. [Donating to help support the Knowledge Book API](#donating)

---

## Donating
Knowledge Book among other various plugins I have worked on are free to use!
Please consider donating to my ko-fi! It helps fund other projects that I am passionate about.

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/E1E6RSLWV)

https://ko-fi.com/apollo30

---

# Installation
Below shows you how to install Knowledge Book API into your project.
## Gradle
Add it in your root build.gradle at the end of repositories:
```java
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
        }
    }
```
Add the dependency
```java
    dependencies {
        implementation 'com.github.Lodestones:Knowledge-Book:VERSION'
    }
```
## Maven
Add the JitPack repository to your build file
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```
Add the dependency
```xml
    <dependency>
        <groupId>com.github.Lodestones</groupId>
        <artifactId>Knowledge-Book</artifactId>
        <version>VERSION</version>
    </dependency>
```

# Documentation
## API
The Knowledge Book API gives you the [MongoJack](https://mongojack.com) API as well as the [@Collection](https://github.com/Lodestones/Knowledge-Book/blob/master/src/main/java/to/lodestone/knowledgebook/annotation/Collection.java) annotation to use.<br />
To hook into the Knowledge Book API, you can use the [KBHook](https://github.com/Lodestones/Knowledge-Book/blob/master/src/main/java/to/lodestone/knowledgebook/KBHook.java) class.

## Usage
Hooking into the Knowledge Book API.

```java
import to.lodestone.knowledgebook.IKnowledgeBookAPI;
import to.lodestone.knowledgebook.KBHook;

public class MainPlugin extends JavaPlugin {
    private KBHook kbHook; // Declare Knowledge Book Hook Variable.

    @Override
    public void onEnable() {
        kbHook = new KBHook(this); // Hook into the Knowledge Book API.       
    }

    public IKnowledgeBookAPI db() { // use this method to access the Knowledge Book API.
        return kbHook.api(); // Retrieve the Knowledge Book API from the Hook.       
    }
}
``` 
As an example, you can convert a Java Class into a MongoDB document.
```java
package to.lodestone.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import to.lodestone.knowledgebook.annotation.Collection;

@Collection(name = "person_collection")
public class Person {

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("socialSecurityNumber")
    private String socialSecurityNumber;

    // For Knowledge Book to initialize an empty object to use getters and setters.
    public Person() {

    }

    public Person(String fullName, String socialSecurityNumber) {
        this.fullName = fullName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("socialSecurityNumber")
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @JsonProperty("socialSecurityNumber")
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
```
How to use Knowledge Book in your plugin:
```java
package to.lodestone.example;

import org.bukkit.plugin.java.JavaPlugin;
import org.mongojack.JacksonMongoCollection;
import to.lodestone.conquest.data.Person;
import to.lodestone.knowledgebook.IKnowledgeBookAPI;
import to.lodestone.knowledgebook.KBHook;

public class TestPlugin extends JavaPlugin {

    private KBHook kbHook;
    @Override
    public void onEnable() {
        this.kbHook = new KBHook(this);

        JacksonMongoCollection<Person> personCollection = this.kbHook.api().getOrCreateCollection(Person.class);
        personCollection.insertOne(new Person("John Doe", "4355678656"));
    }

    public IKnowledgeBookAPI db() {
        return kbHook.api();
    }
}
```
Once you've started up your server, it will create a collection called `person_collection` with a new Person document with all of the data you've provided.
![Knowledge Book at work](https://cdn.modrinth.com/data/cached_images/73879854a431b7affcf0f2afebbfd245d849a1f7.png)
Remember to set your variables with the correct values in order for Knowledge Book to properly function within the "config.yml" file!
```yml
database: null
connectionString: null
```

---

# Contributing
See something Knowledge Book doesn't support, a bug or something that may be useful? We welcome contributions to improve the Knowledge Book API. Open an issue [here](https://github.com/Lodestones/Knowledge-Book/issues).

---

# License
Knowledge Book is protected by [Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc/4.0/legalcode.txt). Please view the license [here](https://github.com/Lodestones/Knowledge-Book/blob/master/LICENSE).

# CelebrityFinder

This is a Spring Boot application with an implementation of algorithm to solve the next problem.

# Problem :  Find the Celebrity
Description:
- In a team of N people, a celebrity is known by everyone but he/she doesn't know anybody.

# Rules
* The celebrity is known by everyone
* The celebrity doesn't know anybody

# suppositions
* If the celebrity is present is only one.
* Is possible that the celebrity isn't present.
* The user can load an external file in csv format with all necessary information.
* The csv file content an int array[n][n] every row content a person, every column said if this person know the other person in the same position of the column.
* The value 0 said that the person doesn't know the other person.
* The value 1 said that the person know the other person.


### Prerequisites

This application need for building and running:

Java 8 ++
Gradle

## How can build the application
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing gradlew
- Execute de command "gradlew clean build"
```sh
    $ gradlew clean build
```

## How can run the application
- Execute de command "gradlew bootrun"
```sh
    $ gradlew bootrun
```
- Open your browser with the url : http://localhost:8080/celebrity

## How can compile the application
- Execute the next command
```sh
    $ gradlew compileJava
```

## How can run the test
- Execute de command "gradlew test"
```sh
    $ gradlew test
```

## How can find the celebrity
- Open your browser with the url: http://localhost:8080/celebrity
- Upload a csv file with everyone
- Click in the "Load" Bootton, if the celebrity is present, the application response with a message and the position of the row in the csv file.

This is an example of the csv file, with the celebrity in the row 5:
```sh
0,0,0,0,1,0
0,0,0,0,1,0
0,0,0,0,1,0
0,0,0,0,1,0
0,0,0,0,0,0
0,0,0,0,1,0
```

You can find more examples in the resources folder (\src\test\resources) of the application

# Autor

Arcesio Arias

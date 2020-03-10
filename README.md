# CelebrityFinder

This is a Spring Boot application wiht a implementation of algorithm to solve the next problem.

# Problem :  Find the Celebrity
Description:
- In a team of N people, a celebrity is known by everyone but he/she doesn't know anybody.

# Rules
* The celebrity is known by everyone
* The celebrity doesn´t know anybody

# suppositions
* If the celebrity is pressent is only one.
* Is possible that the celebrity isn't present.
* The user can load a external file in format csv with all necessary information.
* The csv file content an array[n][n] every row contein a person, every column say if this person know the other person in the same position of the colunm.
* The value 0 say that the person doesn't know the other person.
* The value 1 say that the person know the other person.
* The celebrity person

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
- Open your broser with the url : http://localhost:8080/person

## How can compile and build the application
- Execute the next commands
```sh
    $ gradlew compile
    $ gradlew build
```

## How can run the test
- Execute de command "gradlew test"
```sh
    $ gradlew test
```

## How can find the celebrity
- Open your browser with the url : http://localhost:8080/person
- upload a csv file with all the people
- clic on the booton "Load", if the celebrity is present the application response with a message and the row position of the celebrity in the csv file.

# License

Licensed under Apache 2.0. Please see [LICENSE](LICENSE) for details.

# Autor

Arcesio Arias

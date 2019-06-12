# Auto-Programming Mentor For Course CS 111

## Description
AutoMentor is a web-based mentoring system that can give back students questions automatically without need to wait for the instructor / TA to give back responses. 

Currently on the webpage it will show several test cases and their corresponding responses, and the developers can call the backend API in order to expand the use into Mobile App. 

Now we only support the auto answering for part of the course 111 questions. More will be added later.

## Installation
### Install Proper IDE
* An IDE (E.g., [IntelliJ IDEA](https://www.jetbrains.com/idea/))

### Install JDK
* [JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* Run below command to check whether you have successfully installed the JDK

```sh
$ java -version
java version "1.8.0_121"
```

### Install Gradle
* [Gradle 4+](http://www.gradle.org/downloads)
* Then you can run below command to check whether you have Gradle successfully installed.

```sh
$ gradle -v

------------------------------------------------------------
Gradle 5.4.1
------------------------------------------------------------
```

### Clone the repository into local disk
* Run below command to clone repository into local disk.
```sh
$ cd Desktop/
$ git clone https://github.com/Hclmaster/AutoMentor-NU.git
```

### Run Project
* Once you clone the AutoMentor-NU repository, open AutoMentor-NU using IDEA
* Click "Edit Configuration" Button at the top right, set the right path of JRE.
* Click the green run button at top right, then the project will run locally on JVM.
* Open `http://localhost:8080/web/jsonShow.html` and you will see the AutoMentor-NU test webpage.

## Known bugs and issues
1. Not cover all the questions for course 111
Currently we just covered small parts of the whole CS 111 questions on Piazza, we will add more later.

2. Not enough course material related responses
The responses we wrote are predefined, and it's stored inside the json file, but for some questions we didn't find useful course-related materials. 

3. Not enough patterns inside Knowledge Base to cover all questions. We use regular expression pattern to help us decide what corresponding responses we should give back to students. Right now, it only covers "Error", "Stuck", "Confused" questions. 

In order to add more patterns, go to `~/AutoMentor-NU/src/main/resources/patterns/test.json`.

Add corresponding responses, go to `~/AutoMentor-NU/src/main/resources/patterns/testResponse.json`.

## Deploy
We use Heroku to deploy our application.

In order to deploy, you need to do the following steps:

1. [Download Heroku CLI](https://devcenter.heroku.com/toolbelt-downloads/osx)

```sh
$ cd Desktop/AutoMentor-NU
$ heroku login
$ git push heroku master
```

2. After that, the application has been published to the Heroku server.

3. You can go to public link to see the website, in my case, it's [AutoMentor test website](https://secure-oasis-87770.herokuapp.com/web/jsonShow.html)

## Demo website
* We already published the [AutoMentor test website](https://secure-oasis-87770.herokuapp.com/web/jsonShow.html)
* Any suggestions are welcomed!

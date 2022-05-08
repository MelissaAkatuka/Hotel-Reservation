Java project with unit tests!
===

This has been created using gradle; to run the tests, just execute:

```
./gradlew test
```

or (on windows machines):

```
gradlew.bat test
```

Read if the following error happens:
"Invalid Gradle JDK configuration found"

After cloning this project into your computer, it might be necessary to do the following steps:

- Close the project
- Delete .gradle and .idea folders

Then, you can re-open it in your IDE (intelliJ is better than netbeans because it builds easier)

This problem occurs because .gradle and .idea must be generated locally on your PC (source: stackoverflow - https://stackoverflow.com/questions/32654016/invalid-jdk-configuration-found-while-importing-a-project-via-gradle)

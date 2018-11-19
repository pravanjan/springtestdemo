Integration testing using spring framwork

Must have -- Gradle and git

Run - Gradle test --info  - This would run the TodoControllerTest class and
execute all 4 test case .

This does not have dev server configure . if you wants to dev server then change
the gradle file to



apply plugin: 'war'
version '1.0-SNAPSHOT'
apply plugin: "com.google.cloud.tools.appengine-standard"

sourceCompatibility = 1.8

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.google.cloud.tools:appengine-gradle-plugin:+'

    }
}
repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile 'org.springframework:spring-webmvc:4.0.2.RELEASE'
    providedCompile group : 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.7'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.9.7'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.9.7'


    testCompile group: 'org.springframework', name: 'spring-test', version: '4.0.2.RELEASE'

}

appengine {
    run {
        port = 8080
    }
    deploy {
        projectId ='youprojectId'
        version = 'todo'
    }
}

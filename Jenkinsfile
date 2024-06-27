pipeline{
    agent none
    stages{
        stage("build and SonarQube Analysis"){
            agent any
            steps{
                withSonarQubeEnv('sonarqube-10.6.0'){
                    sh 'mvn clean package sonar:sonar'
                }}}}}

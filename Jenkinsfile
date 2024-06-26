pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository using Git plugin
                git branch: 'main', url: 'https://github.com/Akshaya626/Webapp-REST-API.git'
            }
        }

        stage('Build') {
            steps {
                dir('') {
                    // Run Maven build
                    bat "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }
        }

        stage('Code Coverage') {
            steps {
                dir('') {
                    // Configure JaCoCo agent for code coverage
                    bat "mvn jacoco:prepare-agent test jacoco:report"

                    // Archive the JaCoCo code coverage report for later analysis
                    archiveArtifacts artifacts: 'target/site/jacoco/index.html', allowEmptyArchive: true
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build and code coverage successful!'
        }
        failure {
            echo 'Build or code coverage failed!'
        }
    }
}

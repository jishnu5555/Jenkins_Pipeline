pipeline {
    agent any

    tools {
        maven 'maven' // Reference the Maven configuration name you've set in Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the code using Maven...'
                sh 'mvn clean install' // This will now use the configured Maven tool
            }
        }
    }
}

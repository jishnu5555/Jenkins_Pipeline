pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the code using Maven...'
                bat 'mvn clean install'  
            }
        }
    }
}

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the code using Maven...'
                bat 'mvn clean install'  // Use 'bat' for Windows
            }
            post {
                success {
                    echo "Build successful. JAR file created and archived."
                }
                failure {
                    echo "Build failed. Check logs for details."
                }
        }
    }
}

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Stage 1: Build - Building the code using Maven."

                    // Navigate to the project folder (adjust the path if necessary)
                    dir('02-vul-coachwebapp') {
                        // Run Maven build command to create the JAR file
                        sh 'mvn clean package -DskipTests=true'

                        // Capture build artifact (JAR file location may need to be adjusted)
                        archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
                    }
                }
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
}

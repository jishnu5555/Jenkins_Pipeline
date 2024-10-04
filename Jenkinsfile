pipeline {
    agent any

    tools {
        maven 'Maven' // Ensure this matches the name configured in Jenkins for Maven
    }

    stages {

        stage('Build') {
            steps {
                script {
                    def mavenHome = tool name: 'Maven', type: 'maven'
                    bat "\"${mavenHome}\\bin\\mvn\" clean package"
                }
            }
        }
    }
}

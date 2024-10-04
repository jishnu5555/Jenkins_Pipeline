pipeline {
    agent any 
    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }
    stages {
        stage('Build') {
            steps {
                bat '"C:\\Users\\jishnu chowdary\\AppData\\Local\\Jenkins\\.jenkins\\tools\\hudson.tasks.Maven_MavenInstallation\\Maven\\bin\\mvn" clean package'
            }
        }
    }
}

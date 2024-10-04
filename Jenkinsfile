pipeline {
    agent any 
    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }
    stages {
        stage('Build') {
            steps {
                dir('02-vul-coachwebapp') {
                    bat '"C:\\Users\\jishnu chowdary\\AppData\\Local\\Jenkins\\.jenkins\\tools\\hudson.tasks.Maven_MavenInstallation\\Maven\\bin\\mvn" clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir('02-vul-coachwebapp') {
                    bat '"C:\\Users\\jishnu chowdary\\AppData\\Local\\Jenkins\\.jenkins\\tools\\hudson.tasks.Maven_MavenInstallation\\Maven\\bin\\mvn" test'
                }
            }
        }
        stage('Code Quality Analysis') {
            steps {
                script {
                    withSonarQubeEnv('LocalSonarQube') {
                        dir('02-vul-coachwebapp') {
                            bat '"C:\\Users\\jishnu chowdary\\AppData\\Local\\Jenkins\\.jenkins\\tools\\hudson.tasks.Maven_MavenInstallation\\Maven\\bin\\mvn" sonar:sonar -Dsonar.projectKey=GIT_HD'
                        }
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                dir('02-vul-coachwebapp') {
                    bat 'docker-compose down || true' // Stop any running container if exists
                    bat 'docker-compose up --build -d' // Build and run in detached mode
                }
            }
        }
    }
}

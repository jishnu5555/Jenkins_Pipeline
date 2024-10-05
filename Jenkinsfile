pipeline {
    agent any 
    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        DD_API_KEY = credentials('Jenkins_key') // Grabs your Datadog API key securely
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
            bat '"C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker-compose.exe" down || true' 
            bat '"C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker-compose.exe" up --build -d'
        }
    }
}

        stage('Monitoring and Alerting') {
            steps {
                // Here we use the Datadog Jenkins plugin to report test results or any data needed to Datadog
                datadog {
                    // Enable reporting of build events, metrics, and logs from Jenkins to Datadog
                    bat 'echo "Reporting build metrics to Datadog..."'
                }
            }
        }
    }
}

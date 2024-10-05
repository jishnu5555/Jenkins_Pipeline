pipeline {
    agent any 
    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        DD_API_KEY = credentials('Jenkins_key') // Grabs your API key securely
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
        stage('Monitoring and Alerting') {
            steps {
                dir('02-vul-coachwebapp') {
                    // Attach Datadog agent to the running container with your API key
                    bat 'docker exec -d 02-vul-coachwebapp-coachwebapp-1 java -javaagent:/app/dd-java-agent.jar -Ddd.agent.host=docker.for.mac.host.internal -Ddd.api.key=$DD_API_KEY'
                }
            }
        }
    }
}

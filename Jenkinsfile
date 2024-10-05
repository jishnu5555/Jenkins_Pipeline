pipeline {
    agent any 
    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        DD_API_KEY = credentials('Jenkins_key') // Datadog API key
        OCTOPUS_API_KEY = credentials('Octopus_API_Key') // Octopus API key from Jenkins credentials
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
        stage('Release') {
    steps {
        script {
            octopusDeployRelease additionalArgs: '',
            releaseVersion: '1.0.${BUILD_ID}',
            project: 'Jenkins_Project', // Change this to your actual project name
            serverId: 'OctopusServer',
            spaceId: 'Spaces-1',
            environment: 'Production',
            tenant: '',
            waitForDeployment: true
        }
    }
}

        stage('Monitoring and Alerting') {
            steps {
                // Report build metrics to Datadog
                datadog {
                    bat 'echo "Reporting build metrics to Datadog..."'
                }
            }
        }
    }
}

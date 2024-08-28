pipeline {
    agent any

    environment {
        DIRECTORY_PATH = 'C:\\Users\\jishnu chowdary\\Downloads\\SIT223'
        TESTING_ENVIRONMENT = 'staging'
        PRODUCTION_ENVIRONMENT = 'jishnu_chowdary'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Fetch the source code from the directory path specified by the environment variable"
                    echo "Compile the code and generate any necessary artifacts"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Unit tests"
                    echo "Integration tests"
                }
            }
        }

        stage('Code Quality Check') {
            steps {
                script {
                    echo "Check the quality of the code"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploy the application to a testing environment specified by the environment variable"
                }
            }
        }

        stage('Approval') {
            steps {
                script {
                    echo "Waiting for approval..."
                    sleep 10
                }
            }
        }

        stage('Deploy to Production') {
            steps {
                script {
                    echo "Deploy the code to the production environment: ${PRODUCTION_ENVIRONMENT}"
                }
            }
        }
    }
}

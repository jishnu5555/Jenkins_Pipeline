pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Stage 1: Build - Building the code using Maven."
                }
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                script {
                    echo "Stage 2: Unit and Integration Tests - Running tests using JUnit."
                    // Capture console output
                    def testOutput = sh(script: 'mvn test', returnStdout: true).trim()
                    // Store console output in the environment variable for later use
                    env.TEST_OUTPUT = testOutput
                }
            }
            post {
                success {
                    // Send success email with console output as attachment
                    mail to: 'jishnugdv@gmail.com',
                        subject: "Success: Unit and Integration Tests - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Unit and Integration Tests stage completed successfully.\n\nLogs:\n${env.TEST_OUTPUT}",
                        attachments: 'test_output.log'
                }
                failure {
                    // Send failure email with console output as attachment
                    mail to: 'jishnugdv@gmail.com',
                        subject: "Failure: Unit and Integration Tests - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Unit and Integration Tests stage failed.\n\nLogs:\n${env.TEST_OUTPUT}",
                        attachments: 'test_output.log'
                }
            }
        }
        stage('Code Analysis') {
            steps {
                script {
                    echo "Stage 3: Code Analysis - Analyzing code using SonarQube."
                }
            }
        }
        stage('Security Scan') {
            steps {
                script {
                    echo "Stage 4: Security Scan - Scanning code for vulnerabilities using OWASP Dependency-Check."
                    // Capture console output
                    def securityOutput = sh(script: 'dependency-check.sh --project MyProject --out .', returnStdout: true).trim()
                    // Store console output in the environment variable for later use
                    env.SECURITY_OUTPUT = securityOutput
                }
            }
            post {
                success {
                    // Send success email with console output as attachment
                    mail to: 'jishnugdv@gmail.com',
                        subject: "Success: Security Scan - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Security Scan stage completed successfully.\n\nLogs:\n${env.SECURITY_OUTPUT}",
                        attachments: 'security_scan_output.log'
                }
                failure {
                    // Send failure email with console output as attachment
                    mail to: 'jishnugdv@gmail.com',
                        subject: "Failure: Security Scan - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Security Scan stage failed.\n\nLogs:\n${env.SECURITY_OUTPUT}",
                        attachments: 'security_scan_output.log'
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                script {
                    echo "Stage 5: Deploy to Staging - Deploying application to a staging server (e.g., AWS EC2 instance)."
                }
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                script {
                    echo "Stage 6: Integration Tests on Staging - Running integration tests on the staging environment."
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                script {
                    echo "Stage 7: Deploy to Production - Deploying application to a production server (e.g., AWS EC2 instance)."
                }
            }
        }
    }

    // Configure job triggers for GitHub commits
    triggers {
        pollSCM('H/1 * * * *') // Polls for changes every 5 minutes
    }
}

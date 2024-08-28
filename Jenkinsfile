pipeline {
    agent any

    triggers {
        // Trigger build after a 1-minute delay when a new commit is detected
        pollSCM('H/1 * * * *')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Stage 1: Build - Compiling and packaging the application using Maven.'
            }
        }

        stage('Unit and Integration Tests') {
            steps {
                echo 'Stage 2: Unit and Integration Tests - Running tests using JUnit.'
                // Simulating a log file creation for email attachment
                sh 'echo "Unit and Integration Tests Logs" > unit_test_log.txt'
            }
            post {
                success {
                    emailext(
                        subject: "Unit and Integration Tests: SUCCESS",
                        body: "The Unit and Integration Tests stage completed successfully.",
                        to: "jishnugdv@gmail.com",
                        attachmentsPattern: 'unit_test_log.txt'
                    )
                }
                failure {
                    emailext(
                        subject: "Unit and Integration Tests: FAILURE",
                        body: "The Unit and Integration Tests stage failed. Please check the attached logs.",
                        to: "jishnugdv@gmail.com",
                        attachmentsPattern: 'unit_test_log.txt'
                    )
                }
            }
        }

        stage('Code Analysis') {
            steps {
                echo 'Stage 3: Code Analysis - Analyzing code using SonarQube.'
            }
        }

        stage('Security Scan') {
            steps {
                echo 'Stage 4: Security Scan - Performing security scan using OWASP Dependency Check.'
                // Simulating a log file creation for email attachment
                sh 'echo "Security Scan Logs" > security_scan_log.txt'
            }
            post {
                success {
                    emailext(
                        subject: "Security Scan: SUCCESS",
                        body: "The Security Scan stage completed successfully.",
                        to: "jishnugdv@gmail.com",
                        attachmentsPattern: 'security_scan_log.txt'
                    )
                }
                failure {
                    emailext(
                        subject: "Security Scan: FAILURE",
                        body: "The Security Scan stage failed. Please check the attached logs.",
                        to: "jishnugdv@gmail.com",
                        attachmentsPattern: 'security_scan_log.txt'
                    )
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Stage 5: Deploy to Staging - Deploying the application to a staging server.'
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo 'Stage 6: Integration Tests on Staging - Running integration tests on the staging environment.'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Stage 7: Deploy to Production - Deploying the application to the production server.'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
    }
}

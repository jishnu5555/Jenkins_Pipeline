pipeline {
    agent any

    triggers {
        githubPush()
        // Add a short delay
        // This is a workaround for Jenkins' lack of direct support for delay on GitHub triggers.
        // For real delay, consider using a scheduled job or a plugin.
    }

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
                    // Simulate creating a log file
                    writeFile file: 'unit_test.log', text: 'Unit Test logs...'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: 'unit_test.log'
                    emailext attachLog: true,
                             to: 'jishnugdv@gmail.com',
                             subject: "Success: Unit and Integration Tests - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                             body: "The Unit and Integration Tests stage completed successfully.\n\nLogs attached."
                }
                failure {
                    archiveArtifacts artifacts: 'unit_test.log'
                    emailext attachLog: true,
                             to: 'jishnugdv@gmail.com',
                             subject: "Failure: Unit and Integration Tests - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                             body: "The Unit and Integration Tests stage failed.\n\nLogs attached."
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
                    // Simulate creating a log file
                    writeFile file: 'security_scan.log', text: 'Security Scan logs...'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: 'security_scan.log'
                    emailext attachLog: true,
                             to: 'jishnugdv@gmail.com',
                             subject: "Success: Security Scan - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                             body: "The Security Scan stage completed successfully.\n\nLogs attached."
                }
                failure {
                    archiveArtifacts artifacts: 'security_scan.log'
                    emailext attachLog: true,
                             to: 'jishnugdv@gmail.com',
                             subject: "Failure: Security Scan - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                             body: "The Security Scan stage failed.\n\nLogs attached."
                    //test for the build trigger
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
}

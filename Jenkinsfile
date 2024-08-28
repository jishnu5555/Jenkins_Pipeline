pipeline {
    agent any
    triggers {
        // Trigger build after a 1-minute delay when a new commit is detected
        pollSCM('H/1 * * * *')
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
                }
            }
            post {
                always {
                    script {
                        // Capture logs up to this stage
                        def logs = currentBuild.rawBuild.getLog(1000).join('\n')
                        writeFile file: 'test_stage.log', text: logs
                        archiveArtifacts artifacts: 'test_stage.log'
                    }
                }
                success {
                    mail to: '',
                        subject: "Success: Unit and Integration Tests - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Unit and Integration Tests stage completed successfully.\n\nPlease find the attached logs up to this stage.",
                        attachmentsPattern: 'test_stage.log'
                }
                failure {
                    mail to: '',
                        subject: "Failure: Unit and Integration Tests - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Unit and Integration Tests stage failed.\n\nPlease find the attached logs up to this stage.",
                        attachmentsPattern: 'test_stage.log'
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
                }
            }
            post {
                always {
                    script {
                        // Capture logs up to this stage
                        def logs = currentBuild.rawBuild.getLog(1000).join('\n')
                        writeFile file: 'security_stage.log', text: logs
                        archiveArtifacts artifacts: 'security_stage.log'
                    }
                }
                success {
                    mail to: 'jishnugdv@gmail.com',
                        subject: "Success: Security Scan - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Security Scan stage completed successfully.\n\nPlease find the attached logs up to this stage.",
                        attachmentsPattern: 'security_stage.log'
                }
                failure {
                    mail to: 'jishnugdv@gmail.com',
                        subject: "Failure: Security Scan - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: "The Security Scan stage failed.\n\nPlease find the attached logs up to this stage.",
                        attachmentsPattern: 'security_stage.log'
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

   

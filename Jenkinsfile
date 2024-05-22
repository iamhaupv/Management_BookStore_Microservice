pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build and Deploy BookService') {
            steps {
                // Pull the Jenkins image using Docker plugin
                docker.image('jenkins/jenkins:latest').pull()
                // Build Docker image for BookService using Docker plugin
                docker.build('bookservice:0.0.1', './BookService')
                // Run Docker container using Docker plugin
                docker.image('bookservice:0.0.1').withRun('-p 8080:8080')
            }
        }
    }
}

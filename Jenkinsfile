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
                script {
                    // Pull the Jenkins image
                    docker.image('jenkins/jenkins:latest').pull()
                    // Build Docker image for BookService
                    docker.build('bookservice:0.0.1', './BookService')
                    // Run Docker container
                    docker.image('bookservice:0.0.1').run('-p 8080:8080')
                }
            }
        }
    }
}

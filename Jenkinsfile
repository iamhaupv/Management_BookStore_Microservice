pipeline {
    agent any
    environment {
        DOCKER_HOME = tool 'docker'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build Docker Image for BookService') {
            steps {
                script {
                    // Đặt biến môi trường Docker Image Tag
                    def dockerImageTag = "bookservice:0.0.1"
                    
                    // Docker build image từ Dockerfile trong thư mục BookService
                    sh "${DOCKER_HOME}/bin/docker build -t ${dockerImageTag} ./BookService"
                }
            }
        }
    }
}

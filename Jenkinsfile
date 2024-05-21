pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Clone mã nguồn từ GitLab
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Đặt biến môi trường Docker Image Tag
                def dockerImageTag = "bookservice:0.0.1"

                // Build Docker image từ Dockerfile trong thư mục BookService
                script {
                    docker.build(dockerImageTag, './BookService')
                }
            }
        }
    }
}

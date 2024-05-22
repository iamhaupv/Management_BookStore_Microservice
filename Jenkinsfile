pipeline {
    agent any
    tools {
        // Chỉ định phiên bản Docker ở đây nếu cần thiết
        dockerTool 'docker-latest'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice']]])
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'docker build -t bookservice -f BookService/Dockerfile BookService'
                }
            }
        }
    }
}

pipeline {
    agent any
    tools {
        dockerTool 'docker' 
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }

        stage('Build and Package Services') {
            steps {
                script {
                    def services = ['BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService']

                    for (def service in services) {
                        // Đặt biến môi trường Docker Image Tag
                        def dockerImageTag = "${service}:0.0.1"

                        // Docker build image từ Dockerfile trong thư mục dự án
                        docker.build(dockerImageTag, "./${service}")
                    }
                }
            }
        }
    }
}

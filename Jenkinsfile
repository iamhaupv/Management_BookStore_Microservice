pipeline {
    agent any
    environment {
        // Danh sách các dịch vụ
        SERVICES = ['BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService']
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build Services') {
            steps {
                script {
                    // Duyệt qua từng dịch vụ và xây dựng
                    for (def service in SERVICES) {
                        // Xây dựng service bằng Maven
                        dir(service) {
                            sh 'mvn clean package'
                        }
                    }
                }
            }
        }
    }
}

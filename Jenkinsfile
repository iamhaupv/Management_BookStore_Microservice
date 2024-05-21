pipeline {
    agent any
    environment {
        // Define environment variables
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
                    // Loop through each service and build
                    for (def service in env.SERVICES) {
                        // Build service using Maven
                        dir(service) {
                            sh 'mvn clean package'
                        }
                    }
                }
            }
        }
    }
}

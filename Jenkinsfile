pipeline {
    agent any

    tools {
        maven 'Maven 3.9.6'
        dockerTool 'docker'
    }
    docker {
            image 'docker:19.03.12' // Use the Docker image
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Mount Docker socket
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build Services') {
            steps {
                script {
                    def services = ['BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService']

                    for (def service in services) {
                        dir(service) {
                            // build mvn
                            sh 'mvn clean package -DskipTests'
                            // Build Docker image
                            sh "docker build -t ${service.toLowerCase()}:0.0.1 ."
                        }
                    }
                }
            }
        }
    }
}

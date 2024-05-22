pipeline {
    agent any

    tools {
        maven 'Maven 3.9.6'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build Services') {
            steps {
                withDockerRegistry(credentialsId: 'microservice-network', toolName: 'docker-latest', url: 'https://index.docker.io/v1/') {
                    script {
                    def services = ['BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService']

                        for (def service in services) {
                            dir(service) {
                                // build mvn
                                sh 'mvn clean package -DskipTests'
                                sh "docker build -t ${service.toLowerCase()}:0.0.1 ."
                            }
                        }
                    }
                }
            }
        }
    }
}
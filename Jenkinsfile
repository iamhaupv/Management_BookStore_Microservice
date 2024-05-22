pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'hau', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
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

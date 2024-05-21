pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Set Environment') {
            environment {
                SERVICES = getServices()
            }
            steps {
                script {
                    // Loop through each service and build
                    for (def service in env.SERVICES) {
                        // Change directory to service and build service using Maven
                        dir(service) {
                            sh 'mvn clean package'
                        }
                    }
                }
            }
        }
    }
}

def getServices() {
    return ['BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService']
}

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
                        // Change directory to service
                        sh "cd ${service}"
                        // Build service using Maven
                        sh 'mvn clean package'
                        // Change back to previous directory
                        sh 'cd ..'
                    }
                }
            }
        }
    }
}

def getServices() {
    return ['BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService']
}

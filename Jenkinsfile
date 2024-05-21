pipeline {
    agent any
    stages {
        stage('Clone stage') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build') {
            matrix {
                axes {
                    axis {
                        name 'SERVICE'
                        values 'BookService', 'APIGateway', 'CartService', 'DiscoveryService', 'OrderService', 'UserService'
                    }
                stages {
                    stage('Build ${SERVICE}') {
                        steps {
                            dir("${SERVICE}") {
                                sh 'mvn clean package'
                            }
                        }
                    }
                }
                }
            }
        }
    }

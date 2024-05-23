pipeline {
    agent any
    tools {
        maven 'Maven 3.9.6'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'hau', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                withDockerRegistry(credentialsId: 'docker-v2', url: 'https://index.docker.io/v1/') {
                    dir('BookService') {
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -t book-service:0.0.1 .'
                    }
                    dir('APIGateway') {
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -t api-gateway-service:0.0.1 .'
                    }
                    dir('CartService') {
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -t cart-service:0.0.1 .'
                    }
                    dir('DiscoveryService') {
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -t discovery-service:0.0.1 .'
                    }
                    dir('OrderService') {
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -t order-service:0.0.1 .'
                    }
                    dir('UserService') {
                        sh 'mvn clean package -DskipTests'
                        sh 'docker build -t user-service:0.0.1 .'
                    }
                }
            }
        }
    }
}

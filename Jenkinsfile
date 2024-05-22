pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS_ID = 'microservice-network'
        DOCKER_REGISTRY_URL = 'https://index.docker.io/v1/'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build BookService') {
            steps {
                script {
                    docker.withRegistry(env.DOCKER_REGISTRY_URL, env.DOCKER_CREDENTIALS_ID) {
                        dir('BookService') {
                            sh 'docker build -t book-service:0.0.1 .'
                        }
                    }
                }
            }
        }
    }
}

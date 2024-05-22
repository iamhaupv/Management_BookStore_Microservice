pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'hau'
        DOCKER_REGISTRY_URL = 'https://index.docker.io/v1/'
        DOCKER_USER = 'gitlab+deploy-token-4298232'
        DOCKER_PASSWORD = credentials('gldt--NjU9o6fxciUJkz8e8Mp')
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Login to Docker') {
            steps {
                script {
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin $DOCKER_REGISTRY_URL'
                }
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

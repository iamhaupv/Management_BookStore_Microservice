pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_URL = 'https://index.docker.io/v1/'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'hau', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Login to Docker') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh '''
                            echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin $DOCKER_REGISTRY_URL
                        '''
                    }
                }
            }
        }
        stage('Build BookService') {
            steps {
                script {
                    docker.withRegistry(env.DOCKER_REGISTRY_URL, 'docker-credentials') {
                        dir('BookService') {
                            sh 'docker build -t book-service:0.0.1 .'
                        }
                    }
                }
            }
        }
    }
}

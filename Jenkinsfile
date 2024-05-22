pipeline {
    agent any
    stages {
        stage('Build and Push Docker Image') {
            steps {
                withDockerRegistry(credentialsId: 'docker-v2', url: 'https://index.docker.io/v1/') {
                    dir('BookService') {
                        sh 'docker build -t book-service:0.0.1 .'
                    }
                }
            }
        }
    }
}

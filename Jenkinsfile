pipeline {
    agent any
    stages {
        stage('Clone stage') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build Deploy') {
            steps {
                withDockerRegistry(credentialsId: 'microservice', url: 'https://index.docker.io/v1/') {
                    sh 'docker-compose up -d'
                }
            }
        }
    }
}

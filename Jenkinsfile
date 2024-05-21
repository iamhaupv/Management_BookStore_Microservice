pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build and Deploy') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'microservice-network', url: 'https://index.docker.io/v1/']) {
                        sh '''
                        docker-compose down
                        docker-compose up --build -d
                        '''
                    }
                }
            }
        }
    }
}
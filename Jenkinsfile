pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build BookService') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'microservice-network', url: 'https://index.docker.io/v1/') {
                        dir('BookService') {
                            sh 'docker build -t bookservice:0.0.1 .'
                        }
                    }
                }
            }
        }
    }
}

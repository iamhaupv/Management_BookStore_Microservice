pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'hau', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build BookService') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'hau', url: 'https://registry-1.docker.io/v2/', branch: 'main') {
                        dir('BookService') {
                            sh 'docker build -t bookservice:0.0.1 .'
                        }
                    }
                }
            }
        }
    }
}

pipeline {
    agent any

    tools {
        dockerTool 'docker-latest'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build BookService Docker Image') {
            steps {
                script {
                    dir('BookService') {
                        sh 'docker build -t bookservice:0.0.1 .'
                    }
                }
            }
        }
    }
}

pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build BookService') {
            steps {
                cd("BookService") {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build CartService') {
            steps {
                cd("CartService") {
                    sh 'mvn clean package'
                }
            }
        }
    }
}

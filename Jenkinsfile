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
                dir("BookService") {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build CartService') {
            steps {
                dir("CartService") {
                    sh 'mvn clean package'
                }
            }
        }
    }
}

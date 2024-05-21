pipeline {
    agent any

    tools {
        // Use the configured Maven installation
        maven 'Maven 3.9.6'  // Ensure this matches the name you configured in Global Tool Configuration
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        
        stage('Build BookService') {
            steps {
                script {
                    // Change directory to BookService and build using Maven
                    dir('BookService') {
                        sh 'mvn clean package'
                    }
                }
            }
        }
    }
}

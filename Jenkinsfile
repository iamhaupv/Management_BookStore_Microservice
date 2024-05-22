pipeline {
    agent any

    tools {
        maven 'Maven 3.9.6'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build Services') {
            steps {
                // This step should not normally be used in your script. Consult the inline help for details.
                withDockerRegistry(credentialsId: 'microservice-network', url: 'https://index.docker.io/v1/') {
                    dir('BookService') {
                        sh 'docker build -t book-serivce:0.0.1 .'
                    }
                }
            }
        }
    }
}

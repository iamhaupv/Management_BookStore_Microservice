pipeline {
    agent {
        docker {
            image 'your-jenkins-agent-image'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice', branch: 'main'
            }
        }
        stage('Build and Deploy BookService') {
            steps {
                script {
                    // Your Docker steps here
                }
            }
        }
    }
}

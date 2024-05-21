pipeline {
    agent {
        docker {
            image 'docker:19.03.12' // Use the Docker image
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Mount Docker socket
        }
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub') // Set your DockerHub credentials ID
    }
    stages {
        stage('Build') {
            steps {
                script {
                    docker.build("your-image-name:${env.BUILD_NUMBER}").inside {
                        sh 'echo "Image built"'
                    }
                }
            }
        }
        stage('Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS) {
                        docker.image("your-image-name:${env.BUILD_NUMBER}").push()
                    }
                }
            }
        }
    }
}

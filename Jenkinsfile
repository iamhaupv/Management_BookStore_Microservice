pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_URL = 'https://index.docker.io/v1/'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'hau', url: 'https://gitlab.com/your-repository.git', branch: 'main'
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    // Đăng nhập vào Docker Registry
                    withDockerRegistry(credentialsId: 'docker-hub', url: env.DOCKER_REGISTRY_URL) {
                        // Di chuyển đến thư mục chứa dự án BookService
                        dir('BookService') {
                            // Xây dựng image Docker
                            sh 'docker build -t your-docker-username/book-service:latest .'

                            // Đẩy image Docker lên Docker Registry
                            sh 'docker push your-docker-username/book-service:latest'
                        }
                    }
                }
            }
        }
    }
}

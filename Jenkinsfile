pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git credentialsId : 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build and Deploy') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'microservice-network-1', url: 'https://index.docker.io/v1/']) {
                        sh '''
                        docker-compose down
                        docker-compose up --build -d
                        '''
                    }
                }
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'microservice-network', url: 'https://index.docker.io/v1/']) {
                        // Define the images to push
                        def images = [
                            'discovery-service',
                            'book-service',
                            'api-gateway',
                            'order-service',
                            'cart-service',
                            'user-service'
                        ]

                        // Define Docker Hub repository prefix
                        def dockerHubRepo = 'bourbon692/management-microservice-bookstore:0.0.1'

                        // Tag and push each image
                        images.each { image ->
                            sh """
                            docker tag ${image}:0.0.1 ${dockerHubRepo}/${image}:0.0.1
                            docker push ${dockerHubRepo}/${image}:0.0.1
                            """
                        }
                    }
                }
            }
        }
    }
}

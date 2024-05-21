pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build Services') {
            steps {
                script {
                    // List all directories in the root directory
                    def directories = sh(script: 'ls -d */', returnStdout: true).trim().split('\n')

                    // Iterate over each directory
                    for (def directory in directories) {
                        def serviceName = directory.take(directory.lastIndexOf('/'))
                        // Go into each service directory
                        dir(directory) {
                            // Build service using Maven
                            sh "mvn clean package"

                            // Build Docker image using Dockerfile
                            sh "docker build -t ${serviceName} ."
                        }
                    }
                }
            }
        }
    }
}

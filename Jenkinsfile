pipeline {
    agent any
    tool{
        dockerTool 'docker-latest'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'docker build -t bookservice .'
                }
            }
        }
    }
}

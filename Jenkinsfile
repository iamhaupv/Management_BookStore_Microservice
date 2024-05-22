pipeline {
    agent any
    tools {
        // Chỉ định phiên bản Docker ở đây nếu cần thiết, ví dụ: dockerTool 'docker-latest'
        // Hoặc thiết lập môi trường Docker theo cách khác nếu không yêu cầu
        dockerTool 'docker-latest'  // Bỏ chú thích dòng này nếu 'dockerTool' là công cụ được cấu hình hợp lệ
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

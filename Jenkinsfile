pipeline {
    agent any
    stages {
        stage('Clone stage') {
            steps {
                git credentialsId: 'microservice-network-1', url: 'https://gitlab.com/longsoisuaxe1a/Management_BookStore_Microservice'
            }
        }
        stage('Build') {
            steps {
                // Sao chép mã nguồn từ kho lưu trữ GitLab
                git credentialsId: 'your-credentials-id', url: 'https://gitlab.com/your-project'
            }
        }
        stage('Matrix Build') {
            matrix {
                axes {
                    axis {
                        name 'SERVICE'
                        values 'BookService', 'APIGateway'
                    }
                }
                stages {
                    stage("Build ${SERVICE}") {
                        steps {
                            // Di chuyển vào thư mục của service và chạy lệnh Maven
                            dir("${SERVICE}") {
                                sh 'mvn clean package'
                            }
                        }
                    }
                }
            }
        }
    }
}
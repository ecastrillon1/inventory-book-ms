pipeline {
    agent any
    stages {
        stage('Checkout') {
                steps {
                    git 'https://github.com/ecastrillon1/inventory-book-ms.git'
                }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}

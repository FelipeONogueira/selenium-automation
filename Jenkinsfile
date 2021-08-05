pipeline {
    agent any

    tools {
        maven "3.8.1"
    }

    stages {
        stage("Build") {
            sh "mvn -version"
            sh "mvn clean install"
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
pipeline {
    agent any

    stages {
        stage("Build") {
            // sh "mvn -version"
            // sh "mvn clean install"
            sh '''git --version
            mvn --version
            java -version
            '''
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
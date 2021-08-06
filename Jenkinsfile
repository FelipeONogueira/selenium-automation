pipeline {
    agent any

    stages {
        
        stage('SonarQube Analysis') {
            def mvn = tool 'Default Maven';
            withSonarQubeEnv() {
                sh "${mvn}/bin/mvn sonar:sonar"
            }
        }

        stage ("Testing Stage") {
            steps {
                sh "mvn test"
            }
        }

        stage("Build") {
            steps {
                sh "java -version"
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
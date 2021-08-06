pipeline {
    agent any

    stages {
        
        stage('SonarQube Analysis') {
            steps {
                //sh "mvn sonar:sonar sonar.projectKey=automated sonar.host.url=http://localhost:9000 sonar.login=2be33c66b453798deadd3ee2ff2c78dc08fc30b4"
                sh "mvn sonar:sonar \ -Dsonar.projectKey=automated \ -Dsonar.host.url=http://localhost:9000 \ -Dsonar.login=2be33c66b453798deadd3ee2ff2c78dc08fc30b4"
            }
            // def mvn = tool 'Default Maven';
            // withSonarQubeEnv() {
            //     sh "${mvn}/bin/mvn sonar:sonar"
            // }
        }

        stage("Testing Stage") {
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
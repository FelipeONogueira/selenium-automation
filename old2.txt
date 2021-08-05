pipeline {
  agent {
    dockerfile {
      filename 'dockerfile'
    }

  }
  stages {

    stage('Git Clone') {

      parallel {

        stage('Git Clone') {

          steps {
            git(url: 'https://github.com/FelipeONogueira/selenium-automation', branch: 'develop', changelog: true, poll: true)
          }

        }
        
        stage('Maven Package') {
          steps {
            sh 'mvn clean package'
          }
        }

      }
    }

    stage('SonarQube analysis') {
      steps {
        withSonarQubeEnv(installationName: 'SonarScanner', envOnly: true) {
	sh 'mvn sonar:sonar -Dsonar.projectKey=api -Dsonar.host.url=http://localhost:9000 -Dsonar.login=28aefadf23813d12e17b6ebdc19d52174ea960cb'
        }

      }
    }

    stage('Build Sucess') {
      steps {
        publishCoverage(applyThresholdRecursively: true, calculateDiffForChangeRequests: true, 
      }
    }

  }
  environment {
    DEV = 'dev'
  }
}
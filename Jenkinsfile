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

        stage('Maven Build') {
          steps {
            sh 'mvn build'
          }
        }

      }
    }

    stage('Sonar Scanner') {
      steps {
        withSonarQubeEnv(installationName: 'SonarScanner', envOnly: true) {
          waitForQualityGate true
        }

      }
    }

    stage('Deploy DEV') {
      steps {
        publishCoverage(applyThresholdRecursively: true, calculateDiffForChangeRequests: true, failBuildIfCoverageDecreasedInChangeRequest: true, failNoReports: true, failUnhealthy: true, failUnstable: true)
      }
    }

  }
  environment {
    DEV = 'dev'
  }
}
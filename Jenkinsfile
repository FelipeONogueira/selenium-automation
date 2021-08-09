pipeline {
  agent any
  
  stages {
    
    // stage('Git Clone') {
    //   steps {
    //     git(url: 'https://github.com/FelipeONogueira/thanos.git', branch: 'develop', changelog: true, poll: true)
    //   }
    // }

    stage('Environment Version') {
      steps {
        sh 'git --version'
        sh 'mvn --version'
        sh 'java -version'
      }
    }
    
    stage('SonarQube analysis') {
      steps{
        withSonarQubeEnv('sonarqube') {
          //sh 'cd ${WORKSPACE}/modules/api'
          sh 'mvn clean package sonar:sonar'
        } // submitted SonarQube taskId is automatically attached to the pipeline context
      }
    }

    // stage("Quality Gate"){
    //   steps{
    //     timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    //       def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    //       if (qg.status != 'OK') {
    //         error "Pipeline aborted due to quality gate failure: ${qg.status}"
    //       }
    //     }
    //   }
    // }

    stage('Build Api') {
      steps {
        withMaven(maven: 'apache-maven-3.0.5') {
          sh 'mvn clean install -DskipTests=true'
          //sh 'mvn clean install -DskipTests=true -f ${WORKSPACE}/modules/api/pom.xml'
        }
      }
    }

  }
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


// pipeline {
//     agent any

//     stages {
        
//         stage('SonarQube Analysis') {
//             steps {
//                 //sh "mvn sonar:sonar sonar.projectKey=automated sonar.host.url=http://localhost:9000 sonar.login=2be33c66b453798deadd3ee2ff2c78dc08fc30b4"
//                 sh "mvn sonar:sonar -Dsonar.projectKey=automated -Dsonar.host.url=http://127.0.0.1:9000" 
//                 //"-Dsonar.login=2be33c66b453798deadd3ee2ff2c78dc08fc30b4"
//             }
//             // def mvn = tool 'Default Maven';
//             // withSonarQubeEnv() {
//             //     sh "${mvn}/bin/mvn sonar:sonar"
//             // }
//         }

//         stage("Testing Stage") {
//             steps {
//                 sh "mvn test"
//             }
//         }

//         stage("Build") {
//             steps {
//                 sh "java -version"
//                 sh "mvn -version"
//                 sh "mvn clean install"
//             }
//         }
//     }

//     post {
//         always {
//             cleanWs()
//         }
//     }
// }
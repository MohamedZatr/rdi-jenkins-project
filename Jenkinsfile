pipeline {
    agent any

    options {
        skipStagesAfterUnstable()
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'

            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') { 
            steps {
                sh './jenkins/scripts/deliver.sh' 
            }
        }
        stage('Publish'){
             steps{
                 script{
                     sshPublisher(publishers: [sshPublisherDesc(configName: 'googlecloud', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sudo kill -9 \\$(lsof -t -i:8000 -sTCP:LISTEN);sudo systemctl jarService', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: '**/target/MapperSpringBoot-1-0.0.1-SNAPSHOT.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                       }
                  }
          
          }
        }
}

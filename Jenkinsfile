pipeline {
    agent any

    environment {
        TOMCAT_HOME = "/opt/tomcat"
        WAR_FILE = "simple-web-app-0.0.1-SNAPSHOT.war"
        DEPLOY_DIR = "${TOMCAT_HOME}/webapps"
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                sh "mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=adm1n -Dsonar.projectKey=simple-web-app -Dsonar.projectName='simple-web-app'"
            }
         }

        stage('Archive the artifacts') {
            steps {
                archiveArtifacts allowEmptyArchive: true, artifacts: 'target/*.war', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    // Copy the archived WAR file to the Tomcat webapps directory
                    def buildInfo = currentBuild.getRawBuild()
                    def warFile = findFiles(glob: 'target/*.war')[0]
                    def targetWarFile = "${buildInfo.artifactsDir}/${warFile}"

                    sh "cp ${targetWarFile} ${DEPLOY_DIR}/${WAR_FILE}"
                }
            }
        }
    }
}

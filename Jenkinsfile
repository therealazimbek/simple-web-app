pipeline {
    agent any

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
                deploy adapters: [tomcat9(credentialsId: '428bc5a1-e411-4f20-aa19-da5afdfb78a8', path: '/manager', url: 'http://localhost:8000')], contextPath: null, onFailure: false, war: '**/*.war'
            }
        }
    }
}

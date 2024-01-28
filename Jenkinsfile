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
            withSonarQubeEnv() {
              sh "mvn clean verify sonar:sonar -Dsonar.projectKey=demo -Dsonar.projectName='demo'"
            }
         }
    }
}

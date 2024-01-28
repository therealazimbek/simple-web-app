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
              sh "mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=adm1n -Dsonar.projectKey=demo -Dsonar.projectName='demo'"
            }
         }
    }
}

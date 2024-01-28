pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn test'
                }
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withMaven(maven: 'maven') {
                    sh "mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=adm1n -Dsonar.projectKey=demo -Dsonar.projectName='demo'"
                }
            }
         }
    }
}

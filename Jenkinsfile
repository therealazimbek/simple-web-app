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
                    sh "mvn clean verify sonar:sonar -Dsonar.token=sqa_8ff76d37289c03e2e0985e59947126f6e4e24186 -Dsonar.projectKey=simple-web-app -Dsonar.projectName='simple-web-app'"
                }
            }
         }
    }
}

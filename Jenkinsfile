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
                    sh "mvn clean verify sonar:sonar -Dsonar.token=sqp_cb7abc0561f8a50c39ee815a045f305a46b2ad8a -Dsonar.projectKey=demo -Dsonar.projectName='demo'"
                }
            }
         }
    }
}

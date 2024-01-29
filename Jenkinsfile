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

    }
}

pipeline {
    agent any
    stages {
        stage('Code Clone') {
            steps {
                git url: "https://github.com/SanketShirke/django-todo-app.git", branch: "main"
                echo 'Code has been cloned'
            }
        }
        stage('Code Build') {
            steps {
                sh "docker build . -t demo-app"
                echo 'code has been build'
            }
        }
        stage('Push the code at docker hub repository') {
            steps {
                withCredentials([usernamePassword(credentialsId: "dockerhub",passwordVariable: "dockerHubpass",usernameVariable: "dockerhHubuser")]){
                    sh "docker login -u ${env.dockerhHubuser} -p ${env.dockerHubpass}"
                    sh "docker tag demo-app:latest ${env.dockerhHubuser}/demo-app:latest"
                    sh "docker push ${env.dockerhHubuser}/demo-app:latest"
                }
                echo 'Pushing the code at Docker hub repo'
            }
        }
        stage('Deploy the application on AWS Instance') {
            steps {
                sh "docker compose down && docker compose up -d"
                echo 'Deployed the application on AWS Instance'
            }
        }
    }
}

pipeline {
    agent any

    stages {
        stage('Code Cloned') {
            steps {
                git url: "https://github.com/SanketShirke/django-todo-app.git" , branch: "main" 
                echo 'Code Cloned'
            }
        }
        stage('Code Build') {
            steps {
                sh "docker build . -t flask-app"
                echo 'Code Build'
            }
        }
        stage('Push the code to the Docker hub') {
            steps {
                withCredentials([usernamePassword(credentialsId:"dockerhub",passwordVariable:"dockerhubpass",usernameVariable:"dockerhubuser")]){
                    sh "docker login -u ${env.dockerhubuser} -p ${env.dockerhubpass}"
                    sh "docker tag  flask-app:latest ${env.dockerhubuser}/flask-app:latest"
                    sh "docker push ${env.dockerhubuser}/flask-app:latest"
                }
                echo 'Push the code to the Docker hub'
            }
        }
        stage('Deploy the Code on AWS') {
            steps {
                sh "docker compose down && docker compose up -d"
                echo 'Deploy the Code on AWS'
            }
        }
    }
}

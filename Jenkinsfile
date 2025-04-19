pipeline {
    agent any  // Run on any available agent

    environment {
        // Define any environment variables if needed
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull the code from your Git repository
                git 'https://github.com/your-repository/simple-quiz-devops.git'  // Replace with your actual repository URL
            }
        }
        
        stage('Build') {
            steps {
                // Compile the backend code using Maven
                script {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                // Run unit tests with Maven
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Dockerize') {
            steps {
                // Build the Docker images using docker-compose
                script {
                    sh 'docker-compose build'
                }
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the containers using docker-compose
                script {
                    sh 'docker-compose up -d'
                }
            }
        }

        stage('Clean Up') {
            steps {
                // Stop the containers and clean up
                script {
                    sh 'docker-compose down'
                }
            }
        }
    }

    post {
        always {
            // Clean up the workspace after the pipeline runs
            cleanWs()
        }
    }
}

pipeline {
    agent any

    stages {
        stage('Building project using ./mvnw ...') {
            steps {
                sh 'bash ./mvnw clean install -Dmaven.test.skip=true'
            }
        }

        stage('Checking for the JAR artifact...') {
            steps {
                script {
                    def artifactPath = sh(
                        script: 'ls target/*.jar',
                        returnStdout: true
                    ).trim()
                    if (artifactPath.empty) {
                        error 'Artifact not found'
                    }
                    echo "Artifact found at ${artifactPath}"
                }
            }
        }

        stage('Stopping and removing the previous container...') {
            steps {
                script {
                    def containerName = "Aqlabs"

                    // Stop and delete the container if it is running
                    try {
                        sh "docker stop $containerName || true"
                        sh "docker rm $containerName || true"
                        echo "Container $containerName stopped and removed."
                    } catch (Exception e) {
                        echo "Failed to stop/remove container $containerName: ${e.getMessage()}"
                    }
                }
            }
        }

        stage('Removing previous docker image and building new image...') {
            steps {
                script {
                    def imageName = "your_image_name"  // Replace with your actual image name

                    // Try to remove the old image if it exists (ignore errors if it doesn't)
                    sh "docker rmi -f $imageName || true"

                    // Build a new image from the current context
                    sh "docker build -t $imageName ."

                    echo "Docker image $imageName removed and replaced with a new one."
                }
            }
        }

        stage('Creating and deploying new container...') {
            steps {
                sh 'sudo docker-compose up --force-recreate -d'
            }
        }
    }
}
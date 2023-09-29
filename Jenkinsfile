pipeline {
    agent any

    stages {
        stage('Building project using ./mvnw ...') {
            steps {
                sh 'bash ./mvnw clean install -Dmaven.test.skip=true'
                // Capture the path to the generated JAR file
                script {
                    def jarPath = sh(returnStdout: true, script: "find target -name '*.jar'")
                    env.JAR_PATH = jarPath.trim()
                }
            }
        }

        stage('Send File via HTTP') {
            steps {
                script {
                    def jarPath = env.JAR_PATH
                    def receiverUrl = 'http://192.168.0.121:5000/receive'

                    // Construct the curl command with variable interpolation
                    def curlCommand = """curl -o /dev/null -w '%{http_code}' -X POST -F 'file=@${jarPath}' ${receiverUrl}"""

                    def status = sh(returnStatus: true, script: curlCommand)

                    if (status == 200) {
                        echo "File successfully received by the server."
                    } else {
                        error "Failed to receive the file. HTTP response code: ${httpResponse}"
                    }
                }
            }
        }

        stage('Next Stage') {
            steps {
                // Add your next stage tasks here
                echo "This is the next stage."
            }
        }
    }
}

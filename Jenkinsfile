pipeline {
    agent any

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'payload', expressionType: 'JSONPath', expression: '$.'],
            ]
        )
    }

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

                    sh "curl -X POST -F 'file=@${jarPath}' ${receiverUrl}"
                }
            }
        }
    }

    post {
        success {
            script {
                def payload = env.payload
                if (payload == 'success') {
                    echo 'File received and accepted, pipeline passes.'
                } else {
                    error 'File acceptance confirmation failed, pipeline fails.'
                }
            }
        }
    }
}

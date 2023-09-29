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
                    def receiverUrl = 'http://192.168.0.121:5000/receive-endpoint'

                    sh "curl -X POST -F 'file=@${jarPath}' ${receiverUrl}"
                }
            }
        }
    }
}

// Use the Generic Webhook Trigger to receive POST requests without a token
triggers {
    GenericTrigger(
        genericVariables: [
            [key: 'payload', expressionType: 'JSONPath', expression: '$.message'],
        ]
    )
}

post {
    success {
        script {
            // Handle the webhook payload here
            def payload = env.payload
            if (payload == 'File received and accepted') {
                echo 'File received and pipeline confirmed acceptance'
            } else {
                error 'File acceptance confirmation failed'
            }
        }
    }
}
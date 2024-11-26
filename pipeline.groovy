
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                eco 'Hello World'
            }
        }
    }

    post {
        failure {
            // Print the job name and build number before triggering the next pipeline
            echo "Job Name: ${JOB_NAME}"
            echo "Build Number: ${BUILD_NUMBER}"
            
            build job: 'heal-pipeline', parameters: [
                    string(name: 'PIPELINE_NAME', value: "${JOB_NAME}"),
                    string(name: 'BUILD_NUMBER', value: "${BUILD_NUMBER}")
                ], wait: false
        }
    }
}


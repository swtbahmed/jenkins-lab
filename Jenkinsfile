pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps {
                git(
                    url: "https://swtbahmed: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@github.com/swtbahmed/jenkins-lab.git",
                    branch: "main"
                )
            }
        }
        stage("Running Maven build") {
            steps {
                sh 'mvn clean install '
            }
        }
        stage("Build Artifact") {
            steps {
                sh 'mvn package'
            }
        }
 
        stage("Running SonarQube Analysis") {
            steps {
                sh 'mvn sonar:sonar  -Dsonar.host.url=http://10.112.61.88:9000  -Dsonar.login=squ_64436e81d074e7e5c223cfee62539e6a6b28f3ad'
            }
        }
    }
}

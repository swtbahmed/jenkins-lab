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
        stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar') {
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
        stage("Running SonarQube Analysis") {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=lab -Dsonar.host.url=http://10.112.61.88:9000  -Dmaven.wagon.http.ssl.insecure=true -Dsonar.login=squ_0536c4adc307dc03d46ace07db24f61db03c010e'
            }
        }
    }
}

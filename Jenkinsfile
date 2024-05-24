pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps {
                git(
                    url: "https://tbswahmed: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@github.com/tbswahmed/jenkins-lab-spring.git",
                    branch: "main",
                    credentialsId: "github-credentials"
                )
            }
        }
        stage("Running Maven Clean and Install") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage("Running SonarQube Analysis") {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=jenkins-lab -Dsonar.host.url=http://10.112.61.88:9000/ -Dsonar.login=squ_a6a2b2e68ddc590d1a0d5d6e46644a975b4f848f'
            }
        }
    }
}

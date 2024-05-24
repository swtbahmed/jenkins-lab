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

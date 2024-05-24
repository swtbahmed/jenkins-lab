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
                sh 'mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true'
            }
        }
        stage("Build Artifact") {
            steps {
                sh 'mvn package'
            }
        }
        stage("Running SonarQube Analysis") {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=lab -Dsonar.host.url=https://sonarqube-cumulus-tools.apps.openshift.sys.onetech-group.corp/ -Dsonar.login=squ_0536c4adc307dc03d46ace07db24f61db03c010e'
            }
        }
    }
}

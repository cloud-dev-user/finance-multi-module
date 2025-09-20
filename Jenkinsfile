node {
    stage('Checkout') {
        checkout scm
    }
    stage('Setup Maven') {
        // Get the installed Maven path by tool name
        def mvnHome = tool name: 'Default', type: 'hudson.tasks.Maven$MavenInstallation'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        echo "Using Maven at: ${mvnHome}"
    }

    stage('Build') {
        sh 'mvn clean install -DskipTests'
    }

    stage('Parallel Tests') {
        parallel(
            "Core Tests": {
                dir('core') {
                    sh 'mvn test'
                    junit '**/target/surefire-reports/*.xml'
                }
            },
            "Tax Tests": {
                dir('tax') {
                    sh 'mvn test'
                    junit '**/target/surefire-reports/*.xml'
                }
            },
            "App Tests": {
                dir('app') {
                    sh 'mvn test'
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        )
    }

    stage('Package') {
        sh 'mvn package -DskipTests'
        archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
    }
}

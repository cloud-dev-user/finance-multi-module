@Library('my-shared-lib') _

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

    // Reusable stages
    mavenBuild()
    parallelMavenTests([
        "Core" : "core",
        "Tax"  : "tax",
        "App"  : "app"
    ])
    mavenPackage()
}

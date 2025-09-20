@Library('my-shared-lib') _

node {
    stage('Checkout') {
        checkout scm
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

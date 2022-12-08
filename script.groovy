
def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    bat 'mvn clean install -D maven.test.skip=true'
    nexusArtifactUploader artifacts: [[artifactId: 'spring-petclinic', classifier: '', file: 'target/spring-petclinic-2.7.3.jar', type: 'jar']], credentialsId: 'nexus-credentials', groupId: 'org.springframework.samples', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', protocol: 'http', repository: '/maven-releases', version: '2.7.3'
}
def sonarScan() {
    echo "Run sonarQube scan..."
    bat "mvn clean verify sonar:sonar -D sonar.projectKey=projet -D maven.test.skip=true  -D sonar.login=sqp_5f53273b9bc7a25846d21721bb48b488011f10d8"
}

return this


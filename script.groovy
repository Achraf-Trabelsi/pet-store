
def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    bat 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}


def sonarScan() {
    echo "Run sonarQube scan..."
    bat "mvn clean verify sonar:sonar -D sonar.projectKey=pipeline -D maven.test.skip=true  -D sonar.login=sqp_5f53273b9bc7a25846d21721bb48b488011f10d8"
}

return this


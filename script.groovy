
def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    bat 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}

def sonarScan() {
    echo "Running sonarQube scan..."
    bat 'mvn test'
    bat 'mvn sonar:sonar -D sonar.login=48d7556f97d0484c006e752b08112ebef5b318c5'
}

return this

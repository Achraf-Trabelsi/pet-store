def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}

def sonarScan() {
    echo "Running sonarQube scan and testing ..."
    sh 'mvn test'
    sh 'mvn sonar:sonar -D sonar.login=squ_eb2ee702c84ca8f40765caac79cadb46aca17ecc'
}

return this

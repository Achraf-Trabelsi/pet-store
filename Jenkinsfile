#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        mvn 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("SonarQube Testing and Scan") {
            steps {
                script {
                    // gv.sonarScan()
                    sh 'echo sonarqube'
                }
            }
        }
        stage("Push JAR to Nexus"){
            steps {
                script {
                    gv.pushToNexus()
                }
            }
        }
    }
}

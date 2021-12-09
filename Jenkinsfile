pipeline {
	agent {
	    label 'docker-agent'
	}
	environment {
	    dockhubCredential='dockhubCredential'
	}
	stages {
		stage('Build') {
			steps {
				sh 'mvn clean compile'
			}
		}
		stage('Unit Testcases') {
			steps{
			 	sh 'mvn test'   
			}
        }
        stage('Integration Testcases') {
			steps{
			 	sh 'mvn verify'   
			}
        }
        stage('Package') {
			steps{
			 	sh 'mvn package'   
			}
        }
        stage('Build & Push Docker Image') {
			steps{
				script {
					dockerImage = docker.build 'rohitchhonker/nagp-assignment:v1'
					docker.withRegistry('', dockhubCredential) {
      					dockerImage.push("v1")
				 	}    
				}
			}
        }
     }
}
		
pipeline {
	agent {
	    label 'EC2'
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
		stage('Run Testcases') {
			steps{
			 	sh 'mvn test'   
			}
        }
        stage('Package') {
			steps{
			 	sh 'mvn package'   
			}
        }
     }
}
		
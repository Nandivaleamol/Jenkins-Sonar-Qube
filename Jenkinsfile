pipeline{

	agent any

	stages{
		stage('Get Git Code'){
			steps{
				git branch: 'main',
				url 'https://github.com/Nandivaleamol/Jenkins-Sonar-Qube.git'
			}
		}

		stage('Build'){
			steps{
				sh 'mvn clean package -DskipTests'
			}
		}
	}
}
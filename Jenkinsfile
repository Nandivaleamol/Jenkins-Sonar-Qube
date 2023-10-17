pipeline{

	agent any

	stages{
		stage('Get Git Code'){
			steps{
				git branch: 'master',
				url: 'https://github.com/Nandivaleamol/Jenkins-Sonar-Qube.git'
			}
		}

		stage('Build'){
			steps{
				sh 'mvn clean package -DskipTests'
			}
		}
		stage('Code Analisys'){
			steps{
				withSonarQubeEnv('Sonar-Qube-Version 9.9.2'){
					sh 'mvn sonar:sonar'
				}
			}
		}
	}
}

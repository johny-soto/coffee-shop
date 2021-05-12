pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Verisión preinstalada en la Configuración del Master
    gradle 'Gradle6.0.1_Centos' //Preinstalada en la Configuración del Master
  }
/*	Versiones disponibles
      JDK8_Mac
      JDK6_Centos
      JDK7_Centos
      JDK8_Centos
      JDK10_Centos
      JDK11_Centos
      JDK13_Centos
      JDK14_Centos
*/

  //Aquí comienzan los “items” del Pipeline
  // stages{
  //   stage('Checkout') {
  //     steps{
  //       echo "------------>Checkout<------------"
  //       checkout([
  //           $class: 'GitSCM', 
  //           branches: [[name: '*/master']], 
  //           doGenerateSubmoduleConfigurations: false, 
  //           extensions: [], 
  //           gitTool: 'Default', 
  //           submoduleCfg: [], 
  //           userRemoteConfigs: [[
  //           credentialsId: 'GitHub_johny-soto', 
  //               url:'https://github.com/johny-soto/coffee-shop'
  //           ]]
  //       ])

  //     }
  //   }
    
  //   stage('Compile & Tests') {
  //     steps{
  //       echo "------------>Compile & Tests<------------"
  //       sh 'ls -a'
  //       sh 'wget -nc https://services.gradle.org/distributions/gradle-7.0.1-all.zip'
  //       sh 'unzip -u gradle-7.0.1-all.zip'
  //       sh 'ls -a'
  //       sh 'chmod +x ./gradle-7.0.1/bin/gradle'
  //       sh './gradle-7.0.1/bin/gradle --b ./coffee-shop-api/domain/build.gradle test'
  //       sh './gradle-7.0.1/bin/gradle --b ./coffee-shop-api/infrastructure/build.gradle test'
  //     }
  //   }

  //   stage('Static Code Analysis') {
  //     steps{
  //       echo '------------>Análisis de código estático<------------'
  //       withSonarQubeEnv('Sonar') {
  //       sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
  //       }
  //     }
  //   }

  //   stage('Build') {
  //     steps {
  //       echo "------------>Build<------------"
  //       //Construir sin tarea test que se ejecutó previamente
  //       sh './gradle-7.0.1/bin/gradle --b ./coffee-shop-api/build.gradle clean'
  //       sh './gradle-7.0.1/bin/gradle --b ./coffee-shop-api/build.gradle build -x test'
  //     }
  //   }  
  // }
  stages {
    stage('Checkout') {
      steps {
        echo "------------>Checkout<------------"
        checkout([
            $class: 'GitSCM', 
            branches: [[name: '*/master']], 
            doGenerateSubmoduleConfigurations: false, 
            extensions: [], 
            gitTool: 'Default', 
            submoduleCfg: [], 
            userRemoteConfigs: [[
            credentialsId: 'GitHub_johny-soto', 
                url:'https://github.com/johny-soto/coffee-shop'
            ]]
        ])
      }
    }
    stage('Compile & Tests') {
      steps {
        echo "------------>Unit Tests<------------"
        dir("coffee-shop-api") {
          sh 'gradle test'
        }
      }
    }
    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
        sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }
    stage('Build') {
      steps {
        echo "------------>Build<------------"
        dir("coffee-shop-api") {
          //Construir sin tarea test que se ejecutó previamente
          sh 'gradle build -x test'
        }
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'johny.soto@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}

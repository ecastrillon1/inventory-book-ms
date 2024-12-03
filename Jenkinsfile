node {

    environment {
        CODECOV_TOKEN = credentials('codecov-token')
        SENTRY_AUTH_TOKEN = credentials('sentry-auth-token')

    }

    stage('Clone sources') {
            checkout([$class: 'GitSCM',
                branches: [[name: '*/develop']],
                userRemoteConfigs: [[url: 'https://github.com/ecastrillon1/inventory-book-ms.git']]
            ])
    }
    stage('Build') {
            bat './gradlew build'
    }

    stage('Test') {
        bat './gradlew test'
    }

    stage('Upload Coverage to Codecov') {
        powershell '''
                    # Forzar el uso de TLS 1.2
                    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

                    # Descargar el script de Codecov
                    $url = "https://codecov.io/bash"
                    $output = Invoke-WebRequest -Uri $url -OutFile "codecov.sh"


                    # Ejecutar el script de Codecov
                    ./codecov.sh -t ${CODECOV_TOKEN}
                '''
    }

    stage('Publish JaCoCo Report') {
        jacoco(
            execPattern: '**/build/jacoco/test.exec', // Ruta al archivo .exec
            classPattern: '**/classes', // Ruta a los archivos de clases
            sourcePattern: '**/src/main/java', // Ruta al código fuente
            inclusionPattern: '**/*.class', // Incluir todos los archivos .class
            exclusionPattern: '**/*Test.class' // Excluir clases de pruebas si es necesario
        )
    }

}
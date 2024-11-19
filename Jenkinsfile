node {
    stage('Clone sources') {
            println("Clonando desde la rama develop")
            checkout([$class: 'GitSCM',
                branches: [[name: '*/develop']],
                userRemoteConfigs: [[url: 'https://github.com/ecastrillon1/inventory-book-ms.git']]
            ])
    }
}

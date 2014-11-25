grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.plugin.location.'collectory-plugin' = "../collectory-plugin"

grails.project.fork = [
    test:   false,
    run:    false,
        console:    false,
        war:        false
]

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://maven.ala.org.au/repository/"
    }

    dependencies {
        runtime 'mysql:mysql-connector-java:5.1.5'
    }

    plugins {
        build ":tomcat:7.0.52.1"

        compile ":marshallers:0.6"          //for customized domain object marshalling with json
        compile ':cache:1.1.2'
        runtime ":hibernate:3.6.10.11"
        runtime ":jquery:1.8.3"
        runtime ":resources:1.2.7"
        runtime ":audit-logging:0.5.5.3"
        compile ":cache-headers:1.1.6"
        runtime ":richui:0.8"
        runtime ":tiny-mce:3.4.4"
    }
}

grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.8
grails.project.source.level = 1.8

//grails.plugin.location."ala-bootstrap2" = "../ala-bootstrap2"
//grails.plugin.location."collectory-plugin" = "../collectory-plugin"

grails.project.fork = [
    test:       false,
    run:        false,
    console:    false,
    war:        false
]

grails.project.dependency.resolver = "maven"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        mavenLocal()
        mavenRepo("http://nexus.ala.org.au/content/groups/public/") {
            updatePolicy 'always'
        }
    }

    dependencies {
        runtime 'mysql:mysql-connector-java:5.1.42'
    }

    plugins {
        runtime ":collectory:1.9.3"
        runtime ":ala-bootstrap3:2.1.2"
        runtime ":resources:1.2.14"
        runtime ":cached-resources:1.0"
        build   ":release:3.1.2"
        runtime ":rest-client-builder:2.1.1"
        runtime (":ala-auth:2.1.4") {
            exclude "servlet-api"
        }
        build ':tomcat:7.0.54'
        compile ":build-info:1.2.6"
        runtime ":ala-admin-plugin:1.3"
    }
}
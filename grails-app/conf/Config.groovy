grails.project.groupId = "au.org.ala" // change this to alter the default package name and Maven publishing destination

grails.appName = "${appName}"

default_config = "/data/${appName}/config/${appName}-config.properties"
if(!grails.config.locations || !(grails.config.locations instanceof List)) {
    grails.config.locations = []
}
if (new File(default_config).exists()) {
    println "[${appName}] Including default configuration file: " + default_config;
    grails.config.locations.add "file:" + default_config
} else {
    println "[${appName}] No external configuration file defined."
}

println "[${appName}] (*) grails.config.locations = ${grails.config.locations}"
println "default_config = ${default_config}"

/******************************************************************************\
 *  SKINNING
 \******************************************************************************/
skin.layout = 'ala2'
skin.orgNameLong = "Atlas of Living Australia"
skin.orgNameShort = "ALA"
// whether crumb trail should include a home link that is external to this webabpp - ala.baseUrl is used if true
skin.includeBaseUrl = true
skin.taxaLinks.baseUrl = "http://bie.ala.org.au/species/"
skin.headerUrl = "classpath:resources/generic-header.jsp" // can be external URL
skin.footerUrl = "classpath:resources/generic-footer.jsp" // can be external URL
skin.fluidLayout = true // true or false
skin.useAlaSpatialPortal = true
skin.useAlaBie = true
skin.taxaLinks.baseUrl = "http://bie.ala.org.au/species/" // 3rd party species pages. Leave blank for no links
test.var = "ala-collectory"

/******************************************************************************\
 *  CAS SETTINGS
 *
 *  NOTE: Some of these will be ignored if default_config exists
 \******************************************************************************/
//grails.serverURL = 'http://devt.ala.org.au:8080/ala-collectory'
//serverName = 'http://devt.ala.org.au:8080'

//security.cas.appServerName = "http://devt.ala.org.au:8080/ala-collectory"
security.cas.casServerName = 'https://auth.ala.org.au'
security.cas.uriFilterPattern = '/admin, /admin/.*'
security.cas.authenticateOnlyIfLoggedInPattern = "/occurrences/(?!.+userAssertions|facet.+).+,/explore/your-area"
security.cas.uriExclusionFilterPattern = '/images.*,/css.*,/js.*'
security.cas.loginUrl = 'https://auth.ala.org.au/cas/login'
security.cas.logoutUrl = 'https://auth.ala.org.au/cas/logout'
security.cas.casServerUrlPrefix = 'https://auth.ala.org.au/cas'
security.cas.bypass = false // set to true for non-ALA deployment
auth.admin_role = "ROLE_ADMIN"


/******************************************************************************\
*  EXTERNAL SERVERS
\******************************************************************************/
if (!bie.baseURL) {
    bie.baseURL = "http://bie.ala.org.au/"
}
if (!bie.searchPath) {
    bie.searchPath = "/search"
}
if (!biocacheUiURL) {
    biocacheUiURL = "http://biocache.ala.org.au"
}
if(!biocacheServicesUrl){
    biocacheServicesUrl = "http://biocache.ala.org.au/ws"
}
if (!spatial.baseURL) {
    spatial.baseURL = "http://spatial.ala.org.au/"
}
if (!ala.baseURL) {
    ala.baseURL = "http://www.ala.org.au"
}
if (!headerAndFooter.baseURL) {
    headerAndFooter.baseURL = "http://www2.ala.org.au/commonui"
}
if(!alertUrl){
    alertUrl = "http://alerts.ala.org.au/"
}
if(!speciesListToolUrl){
    speciesListToolUrl = "http://lists.ala.org.au/speciesListItem/list/"
}

if(!alertResourceName){
    alertResourceName = "Atlas"
}
if(!uploadFilePath){
    uploadFilePath = "/data/ala-collectory/upload/"
}
if(!uploadExternalUrlPath){
    uploadExternalUrlPath = "/upload/"
}
/******************************************************************************\
*  RELOADABLE CONFIG
\******************************************************************************/
//reloadable.cfgPollingFrequency = 1000 * 60 * 60 // 1 hour
//reloadable.cfgPollingRetryAttempts = 5
//reloadable.cfgs = ["file:/data/collectory/config/Collectory-config.properties"]
reloadable.cfgs = ["file:/data/${appName}/config/${appName}-config.properties"]

/******************************************************************************\
*  TEMPLATES
\******************************************************************************/
if (!citation.template) {
    citation.template = 'Records provided by @entityName@, accessed through ALA website.'
}
if (!citation.link.template) {
    citation.link.template = 'For more information: @link@'
}
if (!citation.rights.template) {
    citation.rights.template = ''
}
if (!resource.publicArchive.url.template) {
    resource.publicArchive.url.template = "${biocacheUiURL}/archives/@UID@/@UID@_ror_dwca.zip"
}
/******************************************************************************\
*  ADDITIONAL CONFIG
\******************************************************************************/
if(!projectNameShort){
    projectNameShort="Atlas"
}
if(!projectName){
    projectName="Atlas of Living Australia"
}
if(!regionName){
    regionName="Australia"
}
if(!collectionsMap.centreMapLon){
    collectionsMap.centreMapLon = '134'
}
if(!collectionsMap.centreMapLat){
    collectionsMap.centreMapLat = '-28.2'
}
if(!collectionsMap.defaultZoom){
    collectionsMap.defaultZoom = '2'
}
if(!eml.organizationName){
    eml.organizationName="Atlas of Living Australia (ALA)"
}
if(!eml.deliveryPoint){
    eml.deliveryPoint="CSIRO Black Mountain Laboratories, Clunies Ross Street, ACTON"
}
if(!eml.city){
    eml.city="Canberra"
}
if(!eml.administrativeArea){
    eml.administrativeArea="ACT"
}
if(!eml.postalCode){
    eml.postalCode="2601"
}
if(!eml.country){
    eml.country="Australia"
}
if(!eml.electronicMailAddress){
    eml.electronicMailAddress = "info@ala.org.au"
}
//
///******* standard grails **********/
grails.project.groupId = 'au.org.ala' // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = true
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      tsv: 'text/tsv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
]
// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
//grails.resources.uri.prefix = ''
grails.resources.adhoc.patterns = ['/images/*', '/data/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.work.dir = "/data/${appName}/cache/"

// The default codec used to encode data with ${}
grails.views.default.codec="html" // none, html, base64
grails.views.gsp.encoding="UTF-8"
grails.converters.encoding="UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder=false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable fo AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// MEW tell the framework which packages to search for @Validateable classes
grails.validateable.packages = ['au.org.ala.collectory']

/******* location of images **********/
// default location for images
repository.location.images = '/data/ala-collectory/data'

grails.plugins.cookie.cookieage.default = 360 * 24 * 60 * 60

disableOverviewMap=false
disableAlertLinks=false
disableLoggerLinks=false


/******************************************************************************\
*  ENVIRONMENT SPECIFIC
\******************************************************************************/

hibernate = "off"

/******************************************************************************\
*  AUDIT LOGGING
\******************************************************************************/
auditLog {
    actorClosure = { request, session ->
        def cas = session?.getAttribute('_const_cas_assertion_')
        def actor = cas?.getPrincipal()?.getName()
        if (!actor) {
            actor = request.getUserPrincipal()?.attributes?.email
        }
        if (!actor) {
            actor = session.username  // injected by data controller for web services
        }
        return actor ?: "anonymous"
    }
    TRUNCATE_LENGTH = 2048
}
auditLog.verbose = false

environments {
    development {
        serverName = 'http://devt.ala.org.au:8080'
        grails.serverURL = 'http://devt.ala.org.au:8080/' + appName
    }
    test {
        serverName = 'http://130.56.248.132'
        grails.serverURL = 'http://130.56.248.132/' + appName
    }
    production {
        serverName = 'http://collections-test.ala.org.au/'
        grails.serverURL = 'http://collections-test.ala.org.au/' + appName
        security.cas.appServerName = serverName
        security.cas.contextPath = "/${appName}"
    }
}

logging.dir = (System.getProperty('catalina.base') ? System.getProperty('catalina.base') + '/logs'  : '/var/log/tomcat6')

//// log4j configuration
//log4j = {
//    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
//           'org.codehaus.groovy.grails.web.pages',          // GSP
//           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
//           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
//           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
//           'org.codehaus.groovy.grails.commons',            // core / classloading
//           'org.codehaus.groovy.grails.plugins',            // plugins
//           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
//           'org.springframework',
//           'org.hibernate',
//           'net.sf.ehcache.hibernate'
//}

log4j = {
    appenders {
        environments {
            production {
                console name: "stdout", layout: pattern(conversionPattern: "%d %-5p [%c{1}]  %m%n"), threshold: org.apache.log4j.Level.INFO
                //rollingFile name: "tomcatLog", maxFileSize: 102400000, file: logging.dir + "/ala-collectory.log", threshold: org.apache.log4j.Level.ERROR, layout: pattern(conversionPattern: "%d %-5p [%c{1}] %m%n")
                //console name: "stdout", layout: pattern(conversionPattern: "%d %-5p [%c{1}]  %m%n"), threshold: org.apache.log4j.Level.WARN
            }
            development {
                console name: "stdout", layout: pattern(conversionPattern: "%d %-5p [%c{1}]  %m%n"), threshold: org.apache.log4j.Level.DEBUG
            }
            test {
                console name: "stdout", layout: pattern(conversionPattern: "%d %-5p [%c{1}]  %m%n"), threshold: org.apache.log4j.Level.INFO
            }
        }
    }

    root {
        // change the root logger to my tomcatLog file
        error 'tomcatLog'
        warn 'tomcatLog'
        additivity = true
    }

    error   'org.codehaus.groovy.grails.web.servlet',        // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.codehaus.groovy.grails.plugins',            // plugins
            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
    info    'grails.app'
    debug   'grails.app',
            'grails.app.services',
            //'grails.app.taglib',
            'au.org.ala.cas',
            'au.org.ala.biocache.hubs'
}
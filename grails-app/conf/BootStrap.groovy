class BootStrap {
    def grailsApplication

    def init = { servletContext ->
        log.info "config.security.cas = ${grailsApplication.config.security.cas}"
        log.info "config.skin.layout = ${grailsApplication.config.skin.layout}"
        log.info "config.biocache.ajax.useProxy = ${grailsApplication.config.biocache.ajax.useProxy}"
        log.warn "config.serverName = ${grailsApplication.config.serverName}"
        log.warn "config.grails.serverURL = ${grailsApplication.config.grails.serverURL}"
    }

    def destroy = {
    }
}

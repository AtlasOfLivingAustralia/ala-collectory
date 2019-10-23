import au.org.ala.collectory.ExtendedPluginAwareResourceBundleMessageSource

// Place your Spring DSL code here
beans = {
    // Custom message source
    messageSource(ExtendedPluginAwareResourceBundleMessageSource) {
        basenames = [
                "file:///var/opt/atlas/i18n/collectory-plugin/messages",
                "file:///opt/atlas/i18n/collectory-plugin/messages",
                "WEB-INF/grails-app/i18n/messages"
        ] as String[]
        cacheSeconds = (60 * 60 * 6) // 6 hours
        useCodeAsDefaultMessage = false
    }
}

// Place your Spring DSL code here
//beans = {
//}

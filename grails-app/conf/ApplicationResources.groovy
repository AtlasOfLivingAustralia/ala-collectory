modules = {
    ala_additions {
        resource url:[dir:'css', file:'ala-additions.css']
    }

    overrides {
        bootstrap {
            dependsOn 'core', 'jquery_ui_custom'
        }
    }
}
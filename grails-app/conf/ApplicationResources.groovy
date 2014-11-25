modules = {
    generic {
        dependsOn 'collectory' //
        resource url:'js/application.js'
        resource url: [dir:'css', file:'generic.css']
    }
}
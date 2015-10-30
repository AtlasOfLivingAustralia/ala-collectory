<g:set var="orgNameLong" value="${grailsApplication.config.skin.orgNameLong}"/>
<g:set var="orgNameShort" value="${grailsApplication.config.skin.orgNameShort}"/>
<g:applyLayout name="main" >
    <head>
        <r:script type="text/javascript" disposition="head">
      var COLLECTORY_CONF = { contextPath: "${request.contextPath}", locale: "${request.locale}" }
        </r:script>
        <r:require modules="jquery, jquery-migration, jquery_i18n, bootstrap,  application, collectory" />
        <g:layoutHead/>
        <hf:head/>
    </head>
    <body class="${pageProperty(name:'body.class')?:'nav-collections'}" id="${pageProperty(name:'body.id')}" onload="${pageProperty(name:'body.onload')}">
    <div class="${fluidLayout?'container-fluid':'container'}" id="main-content">
        <g:layoutBody />
    </div><!--/.container-->
    </body>
</g:applyLayout>
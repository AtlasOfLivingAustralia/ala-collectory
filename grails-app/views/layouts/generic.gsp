<g:set var="orgNameLong" value="${grailsApplication.config.skin.orgNameLong}"/>
<g:set var="orgNameShort" value="${grailsApplication.config.skin.orgNameShort}"/>
<g:applyLayout name="main">
    <head>
        <title><g:layoutTitle/></title>
        <g:set var="fluidLayout" value="${pageProperty(name:'meta.fluidLayout')?:grailsApplication.config.skin?.fluidLayout}"/>
        <meta name="breadcrumb" content="${pageProperty(name: 'meta.breadcrumb', default: pageProperty(name: 'title').split('\\|')[0].decodeHTML())}"/>
        <meta name="breadcrumbParent" content="${pageProperty(name: 'meta.breadcrumbParent', default: "${createLink(action: 'map', controller: 'public')},${message(code: 'breadcrumb.collections')}")}"/>
        <r:script type="text/javascript" disposition="head">
      var COLLECTORY_CONF = {
        contextPath: "${request.contextPath}",
        locale: "${request.locale}",
        cartodbPattern: "${grailsApplication.config.cartodb.pattern}"
      };

      // Init plugins
      jQuery(function(){
          $('.helphover').popover({animation: true, trigger:'hover'});
      });
        </r:script>
        <link rel="alternate" type="application/rss+xml" title="RSS Feed" href="${g.createLink(uri:"/feed.xml", absolute: true)}" />
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
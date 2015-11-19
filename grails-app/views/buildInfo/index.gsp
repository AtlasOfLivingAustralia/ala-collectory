<html>
<head>
    <meta name="layout" content="${grailsApplication.config.skin.layout}" />
    <title>Build Info</title>
    <style type="text/css">
    h1 {
        color: #48802c;
        font-weight: normal;
        font-size: 20px;
        margin: .8em 0 .3em 0;
    }

    table {
        border: 1px solid #ccc;
        font-size: 14px;
    }

    tr {
        border: 0;
    }

    td, th {
        padding: 5px 6px;
        text-align: left;
        vertical-align: top;
    }

    </style>

</head>
<body>
<div id="pageBody"> 
    <g:render template="/buildInfo/buildInfo" plugin="buildInfo"/>

    <g:render template="/buildInfo/runtimeStatus" plugin="buildInfo"/>

    <g:render template="/buildInfo/installedPlugins" plugin="buildInfo"/>
</div>
</body>
</html>
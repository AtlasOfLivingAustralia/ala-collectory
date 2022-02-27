/*
 * Copyright (C) 2022 Atlas of Living Australia
 * All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 */
dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = ""
//    logSql = true
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost:3306/collectory?autoReconnect=true&connectTimeout=0&useSSL=false"
            username = "root"
            password = ""
//            logSql = true
        }
    }
    test {
        dataSource {
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/collectory?autoReconnect=true&connectTimeout=0&useSSL=false"
//            logSql = true
            username = "root"
            password = ""
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
                validationQuery = ""
            }
        }
    }
    production {
        dataSource {
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/collectory?autoReconnect=true&connectTimeout=0&useSSL=false"
            logSql = false
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
                validationQuery = ""
            }
        }
    }
}

import au.org.ala.collectory.ActivityLog

security {
	active = false

	loginUserDomainClass = "au.org.ala.security.Logon"
	authorityDomainClass = "au.org.ala.security.Role"
	requestMapClass = "au.org.ala.security.SecRequestMap"

    useSecurityEventListener = true
}

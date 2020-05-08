##webber.security
|Key|Default Value|Description|
|---|---|---|
|webber.security.required-roles|null|This is the role that a user is required to have in order to access any page by default. The rule that applies this requirement will have the lowest precedence so applications may increase or decrease the security for particular URLs as they wish. The default value is "USER" which is applied automatically to every account that authenticates via SSO. Therefore, if you do not wish anybody with an SSO account to be able to access your application, you will need to change this to something else, and ensure that select accounts are given this role.|
|webber.security.secure-home-page|false|By default, the home page, '/', will be left unsecured meaning that anybody can access it, without having to login. By setting this to true, the home page will instead require a login and will also require the same set of roles for other secured pages. See {@link #requiredRoles}|

##webber.security.switchuser
|Key|Default Value|Description|
|---|---|---|
|webber.security.switchuser.roles|null|This is an array of authorities of which any will allow a user to impersonate other users. This defaults to { Roles.ADMINISTRATOR }. Note that Spring Security's "ROLE_" prefix, will be automatically prepended.|
|webber.security.switchuser.success-path|/|This is the domain relative path that will be redirected to after a user successfully impersonates another user. It defaults to "/". It is your responsibility to ensure that your application has a controller that can handle this path. Note that if this path is not accessible by the new user, then you will get an authorisation failure.|

##webber.view
|Key|Default Value|Description|
|---|---|---|
|webber.view.deprecated-layout|true|null|
|webber.view.navbar-expand-breakpoint|navbar-expand-md|null|
|webber.view.webber-deprecated-layout|true|null|
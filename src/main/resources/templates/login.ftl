<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
Login page
<@login.login "/login" />
<a href="/registration">Add new username</a>
</@common.page>
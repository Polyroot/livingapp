<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
Add new username
<div>${message}</div>
<@login.login "/registration" />
</@common.page>
<#import "parts/common.ftl" as common>
<@common.page>
<div>
    Картинка
</div>

<div>
    <form method="post" enctype="multipart/form-data">
        <input type="file" name="picture">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Загрузить</button>
    </form>
</div>

<#list pictures as picture>
<div>
    <div>
        <#if picture.picturename??>
        <img src="/img/${picture.picturename}">
        </#if>
    </div>
</div>
<#else>
No messages
</#list>

</@common.page>
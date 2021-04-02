<html lang="en">
<#include "base.ftlh">
<#macro title>Exception Details</#macro>
<#macro content>
    <h2> Exception Details: </h2><br>
    <strong>Status code:</strong>${statusCode}<br>
    <strong>Request uri:</strong>${uri}<br>
    <#if message??><strong>Message:</strong>${message}</#if><br>
</#macro>
</html>
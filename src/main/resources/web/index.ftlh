<!doctype html>
<html>
<#include "base.ftlh">
<#macro title>Post your own Recipe!</#macro>
<#macro content>
<#--    <#list recipes as recipe>-->
<#--        <tr>-->
<#--            <td>${recipe.id}</td>-->
<#--            <td>${recipe.title}</td>-->
<#--        </tr>-->

<#--        <a href='/index?page=1'>3</a>-->
<#--        <a href='/index?page=2'>3</a>-->
<#--        <a href='/index?page=3'>3</a>-->

<main role="main">
        <div class="album py-5 bg-light ml-5">
            <h1 class="card-title">Тренды</h1>
            <div class="row mr-2 ml-2">
                <#list recipes as recipe>
                    <div class="col-md-4">
                        <a class="text-dark" style="text-decoration: none" href="/review?id=${recipe.id}">
                            <div class="card mb-4 shadow-sm">
                                <img src="/image/${recipe.id}/${recipe.thumbnail}">

<#--                                    <svg class="bd-placeholder-img card-img-top" width="100%" height="350"-->
<#--                                         xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice"-->
<#--                                         focusable="false"-->
<#--                                         role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title>-->
<#--                                        <rect width="100%" height="100%" fill="#55595c"></rect>-->
<#--                                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">Брошура</text>-->
<#--                                    </svg>-->

                                <div class="card-body">
                                    <p class="card-text">${recipe.title}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-sm btn-outline-secondary">Подробнее
                                            </button>
                                            <button type="button" class="btn btn-sm btn-outline-secondary">Отзыв
                                            </button>
                                        </div>
                                        <small class="text-muted">169 минут</small>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </#list>
            </div>
        </div>
</main>

</#macro>
</html>
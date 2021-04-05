<!doctype html>
<html>
<#include "base.ftlh">
<link type="text/css" rel="stylesheet" href="./css/review.css">
<#macro title>Write Your Reviews!</#macro>
<#macro content>
    <main role="main">
        <div class="container col-md-8 mt-4">
            <div class="col-md-8 mb-8 align-content-center">
                <h1 class="display-4 center">
                    ${recipe.title}
                </h1>
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="1" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="0"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="/image/${recipe.id}/${recipe.thumbnail}" class="d-block w-100" alt="...">
                        </div>
                        <#list images as image >
                            <div class="carousel-item">
                                <img src="/image/${recipe.id}/${image.name}" class="d-block w-100" alt="...">
                            </div>
                        </#list>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

                <div class="media">
                    <h2>
                        ${recipe.text}
                    </h2>
                </div>

            </div>
            <div class="comments">
                    <div class="form-group">
                        <label for="rating">Rating</label>
                        <select id="rating" name="rating" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="messageFiled">Текст Сообщения
                        </label><textarea id="messageFiled" name="message" class="form-control" rows="5"></textarea>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button id="sendReview" type="submit" class="btn btn-primary">Отправить</button>
                        </div>
                    </div>
                    <input type="hidden" id="recipeId" value="${recipe.id}">
                <h3 class="title-comments">Отзывы (6)</h3>
                <ul id="comments" class="media-list">
                    <!-- Комментарий (уровень 1) -->
                    <li class="media">
                        <div class="media-body">
                            <#list reviews as review>
                                <div class="panel panel-primary">
                                    <div class="panel-body">
                                        <div class="media-text text-justify">${review.message}
                                        </div>
                                    </div>
                                    <#--                                    <div class="panel-footer">-->
                                    <#--                                        <a class="btn btn-primary btn-dark mt-2" href="#">Ответить</a>-->
                                    <#--                                    </div>-->
                                </div>
                            </#list>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </main>
</#macro>
<script>
    $(document).ready(function () {
        console.log("Documents is ready")
        $('#sendReview').click(function () {
            let rating = $('#rating').val();
            let messageFiled = $('#messageFiled').val();
            let recipeId = $('#recipeId').val();

            $.ajax({
                type: "POST",
                url: "/createReview",
                data: {"rating": rating, "message": messageFiled, "recipeId": recipeId},
                success: function (data) {
                    if (data === 'TRUE') {
                        $('#comments').append(messageFiled)
                        $('#comments').append("</br>")
                    } else {
                        alert('Fail....');
                    }
                }
            });
        });
    });
</script>
</html>
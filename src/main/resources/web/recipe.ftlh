<!doctype html>
<html>
<#include "base.ftlh">
<#macro title>Post your own Recipe!</#macro>
<#macro content>
    <main role="main">
        <section class="album py-5 bg-light">
            <div class="jumbotron text-left">
                <div class="container">
                    <h1 class="card-title text-center">Добавьте свой рецепт</h1>
                    <form action="/recipe" method="post" enctype="multipart/form-data">
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 col-form-label">Название Рецепта</label>
                            <div class="col-sm-10">
                                <input name="title" type="text" class="form-control" id="name" placeholder="Например Хлеб" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="surname" class="col-sm-2 col-form-label">Шаги рецепта</label>
                            <div class="col-sm-10">
                                <textarea name="text" type="text" class="form-control" id="surname" placeholder="Описание Вашего Рецепта"
                                          required rows="6"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="files" class="col-sm-2 col-form-label">Картинки</label>
                            <div class="col-sm-10">
                                <input id="files" type="file" name="file" multiple="true" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">Отправить</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </main>
</#macro>
</html>
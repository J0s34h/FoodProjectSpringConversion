<!doctype html>
<html>
<#include "base.ftlh">
<#macro title>Your Profile</#macro>
<#macro content>
    <div class="container">
        <div class="row my-2 mt-4">
            <div class="col-lg-8 order-lg-2">
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a href="" data-target="#profile" data-toggle="tab" class="nav-link active text-dark">Профиль</a>
                    </li>
                    <li class="nav-item">
                        <a href="" data-target="#messages" data-toggle="tab" class="nav-link text-dark">Сообщения</a>
                    </li>
                    <li class="nav-item">
                        <a href="" data-target="#edit" data-toggle="tab" class="nav-link text-dark">Редактировать</a>
                    </li>
                </ul>
                <div class="tab-content py-4">
                    <div class="tab-pane active" id="profile">
                        <h5 class="mb-3">Профиль Пользователя</h5>
                        <div class="row">
                            <div class="col-md-6">
                                <h6>О пользователе</h6>
                                <p>
                                    Типо данные о нем по типу дата регистраций / стаже колво комментах
                                    Лушче их разделять на h6 для типа данных как например "О пользователе" и "хобби"
                                    а в тэг "<\p\>" пихать текст
                                </p>
                                <h6>Любимый фильм</h6>
                                <p>
                                    Все фильмы одобренные партией
                                </p>
                            </div>
                        </div>
                        <!--/row-->
                    </div>
                    <div class="tab-pane" id="messages">
                        <table class="table table-hover table-striped">
                            <tbody>
                            <tr>
                                <td>
                                    <a href="FilmView.html" class="text-dark">
                                        <span class="float-right font-weight-bold">Время отзыва / коммента </span>
                                        Текст Любого из отзывов и ссылка на сам фильм
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="FilmView.html" class="text-dark">
                                        <span class="float-right font-weight-bold">Время отзыва / коммента </span>
                                        Текст Любого из отзывов и ссылка на сам фильм
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="FilmView.html" class="text-dark">
                                        <span class="float-right font-weight-bold">Время отзыва / коммента </span>
                                        Текст Любого из отзывов и ссылка на сам фильм
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="FilmView.html" class="text-dark">
                                        <span class="float-right font-weight-bold">Время отзыва / коммента </span>
                                        Текст Любого из отзывов и ссылка на сам фильм
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="FilmView.html" class="text-dark">
                                        <span class="float-right font-weight-bold">Время отзыва / коммента </span>
                                        Текст Любого из отзывов и ссылка на сам фильм
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="edit">
                        <form role="form">
                            <div class="form-group row">
                                <label class="col-lg-3 col-form-label form-control-label">Логин</label>
                                <div class="col-lg-9">
                                    <input class="form-control" type="text" value="Юзер">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-lg-3 col-form-label form-control-label">Пароль</label>
                                <div class="col-lg-9">
                                    <input class="form-control" type="password" value="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-lg-3 col-form-label form-control-label">Подтверждение пароля</label>
                                <div class="col-lg-9">
                                    <input class="form-control" type="password" value="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-lg-3 col-form-label form-control-label"></label>
                                <div class="col-lg-9">
                                    <!--                                <input type="reset" class="btn btn-secondary" value="Отмена">-->
                                    <input type="button" class="btn btn-primary" value="Сохранить Изменения">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 order-lg-1 text-center">
                <img src="//placehold.it/150" class="mx-auto img-fluid img-circle d-block" alt="avatar">
                <!--            <h6 class="mt-2">Загрузи свою фотку</h6>-->
                <!--            <label class="custom-file">-->
                <!--                <input type="file" id="file" class="custom-file-input">-->
                <!--                <span class="custom-file-control">Выбрать файл</span>-->
                <!--            </label>-->
            </div>
        </div>
    </div>

</#macro>
</html>
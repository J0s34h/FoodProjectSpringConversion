<html lang="en">
<head>
    <title><@title></@title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <head>
        <title>Index Page</title>

        <link type="text/css" rel="stylesheet" href="/css/bootstrap-reboot.css">
        <link type="text/css" rel="stylesheet" href="/css/bootstrap-grid.css">
        <link type="text/css" rel="stylesheet" href="/css/bootstrap.css">

        <link type="text/css" rel="stylesheet" href="/css/index.css">
        <#--        <link rel="icon" href="favicon-film.png">-->

        <meta charset="utf-8">
    </head>
</head>

<body>
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">О нас</h4>
                    <p class="text-muted">Сайт отзывов на различные фильмы одобренные министерством культуры РСФСР
                    </p>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Контакты</h4>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Напишите нам на почту</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


    <div class="navbar navbar-dark bg-dark">
        <div class="container d-flex justify-content-between">
            <a href="#" class="navbar-brand d-flex align-items-center">
                <img class="icon-img" src="favicon-film.png" width="40px" height="40px" alt="Icon">
                <strong class="logo">Рецепты ООО</strong>
                <a class="nav-link" href="/">Главная<span class="sr-only">(current)</span></a>
                <!--                <a class="nav-link" href="#">Жанры</a>-->
                <a class="nav-link" href="/user">Профиль</a>
                <a class="nav-link" href="/register">Регистрация</a>
                <a class="nav-link" href="/sign_in">Авторизация</a>
                <a class="nav-link" href="/recipe">Добавить рецепт</a>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Поиск" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                </form>
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader"
                    aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>



<div class="content1">
    <div class="content"><@content></@content></div>
</div>



<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Вернутся наверх</a>
        </p>
    </div>
</footer>

</body>

<footer>
    <script src="./js/bootstrap.bundle.js"></script>
    <script src="./js/bootstrap.js"></script>
</footer>

</html>
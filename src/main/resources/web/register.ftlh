<!doctype html>
<html>
<#include "base.ftlh">
<#macro title>Registration Page</#macro>
<#macro content>
    <main role="main">
        <section class="album py-5 bg-light">
            <div class="jumbotron text-left">
                <div class="container">
                    <h1 class="card-title text-center">Регистрация</h1>
                    <form>
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 col-form-label">Имя</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name" placeholder="Например Павел" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="surname" class="col-sm-2 col-form-label">Фамилия</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="surname" placeholder="Например Иванов"
                                       required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="email" class="col-sm-2 col-form-label">Почта</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" placeholder="Например test@gmail.com"
                                       required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="password" class="col-sm-2 col-form-label">Пароль</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" placeholder="Пароль" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="passwordRep" class="col-sm-2 col-form-label">Повтор</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="passwordRep"
                                       placeholder="повторение пароля" required>
                            </div>
                            <div class="invalid-feedback">
                                Please choose a username.
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button id="login" type="submit" class="btn btn-primary">Отправить</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </main>
</#macro>
<footer>
    <script>
        $(document).ready(function () {
            console.log("Documents is ready")
            $('#login').click(function () {
                let email = $('#email').val();
                let pwd = $('#password').val();
                let pwdRep = $('#passwordRep').val();
                let name = $('#name').val();
                let surname = $('#surname').val();

                if (pwd !== pwdRep) {
                    alert("PASSWORD MISMATCH")
                } else {
                    console.log("Sending ajax request")
                    $.ajax({
                        type: "POST",
                        url: "/register",
                        data: {name: name, lastname: surname, email: email, password: pwd},
                        success: function (result) {
                            console.log("Received callback")
                            if (result === "TRUE") {
                                alert('SUCCESS');
                                $(location).attr('href', '/ ');
                            } else {
                                alert('Fail....');
                            }
                        },
                        fail: function (error) {
                            print(error)
                        }
                    });
                }
            });
        });
    </script>
</footer>
</html>
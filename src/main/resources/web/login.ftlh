<!doctype html>
<html>
<#include "base.ftlh">
<#macro title>Login with your Account</#macro>
<#macro content>
    <main role="main">
        <section class="album py-5 bg-light">
            <div class="jumbotron text-left">
                <div class="container">
                    <h1 class="card-title text-center mb-5">Залогиниться</h1>
                    <form action="/login" method="post">
                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-2 col-form-label">Логин</label>
                            <div class="col-sm-10">
                                <input name="login" class="form-control" id="inputEmail3" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                            <div class="col-sm-10">
                                <input name="password" type="password"  class="form-control" id="inputPassword3" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">Залогинится</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </main>

</#macro>
</html>
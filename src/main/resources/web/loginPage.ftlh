<!doctype html>
<html>
<#include "base.ftlh">
<#macro title>Login with your Account</#macro>
<#macro content>
    <main role="main">
        <section class="album py-5 bg-light">
            <div class="jumbotron text-left">
                <div class="container">
                    <form class="form-signin" method="post" action="/login">
                        <h2 class="form-signin-heading">Please sign in</h2>
                        <p>
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" id="username" name="email" class="form-control" placeholder="Username" required="" autofocus="">
                        </p>
                        <p>
                            <label for="password" class="sr-only">Password</label>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
                        </p>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>
            </div>
        </section>
    </main>

</#macro>
</html>
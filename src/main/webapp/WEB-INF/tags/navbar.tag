<%@tag import="com.diary.model.User"%>
<%@tag description="navbar" pageEncoding="UTF-8"%>
<% User currentUser = (User) session.getAttribute("user");%>

<header>
    <nav class="blue lighten-2" role="navigation">
        <div class="nav-wrapper container">

            <a href="." class="brand-logo">Персональный дневник</a>

            <ul class="right hide-on-med-and-down">
                <li><a href="."><i class="material-icons right">home</i> Главная</a></li>
                    <% if (currentUser == null) {%>
                <li><a href="./register"><i class="material-icons right">person_add</i> Регистрация</a></li>
                <li><a href="./login"><i class="material-icons right">exit_to_app</i> Войти</a></li>
                    <% } else { %>
                <li><a href="./mydiaries"><i class="material-icons right">library_books</i> Мой дневник</a></li>
                <li><a href="./logout"><i class="material-icons right">exit_to_app</i> Выйти</a></li>
                    <% } %>
            </ul>

            <ul id="nav-mobile" class="sidenav">
                <li class="active"><a href="."><i class="material-icons left">home</i> Главная</a></li>
                    <% if (currentUser == null) {%>
                <li><a href="./register"><i class="material-icons left">person_add</i> Регистрация</a></li>
                <li><a href="./login"><i class="material-icons left">exit_to_app</i> Войти</a></li>
                    <% } else { %>
                <li><a href="./mydiaries"><i class="material-icons left">library_books</i> Мой дневник</a></li>
                <li><a href="./logout"><i class="material-icons left">exit_to_app</i> Выйти</a></li>
                    <% }%>
            </ul>

            <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</header>

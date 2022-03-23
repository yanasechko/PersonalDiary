<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
    <div class="card-panel">
        <a href="add" class="waves-effect waves-light btn blue"><i class="material-icons left">add</i>Добавить</a>
        <table class="striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Дата</th>
                    <th>Публично</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <t:diary_list_admin />
            </tbody>
        </table>
    </div>
</t:layout>

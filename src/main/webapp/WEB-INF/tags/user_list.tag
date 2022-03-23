<%@tag import="com.diary.model.User"%>
<%@tag import="java.util.List"%>
<%@tag description="userList" pageEncoding="UTF-8"%>

<% List<User> userList = (List) request.getAttribute("userList"); %>

<ul class="collection with-header">
    <li class="collection-header">
        <h5>Здесь вы можете прочитать открытые дневники других пользователей:</h5>
        </li>
        <% for (User user : userList) {%>
    <a href="profile?user_id=<%=user.getId()%>" class="collection-item"><%=user.toString()%></a>
    <%}%>
</ul>

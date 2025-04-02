<%@ page import="pack.business.DataDto" %>
<%@ page
        contentType="text/html;charset=UTF-8"
        pageEncoding="UTF-8"
%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>

<%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");

    DataDto dto = processDao.selectMember(id);
//    System.out.println(dto.getId());
%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>* 회원 수정 *</h2>
<form action="upok.jsp" method="post">
    id : <%=dto.getId()%>
    <input type="hidden" name="id" value="<%=dto.getId()%>">
    <br>
    name : <input type="text" name="name" value="<%=dto.getName()%>"><br>
    qwd : <input type="text" name="passwd"><br>
    <input type="submit" value="수정">
</form>
</body>
</html>

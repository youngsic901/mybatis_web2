<%@ page
        contentType="text/html;charset=UTF-8"
        pageEncoding="UTF-8"
%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="bean" class="pack.business.DataFormBean"/>
<jsp:setProperty name="bean" property="*"/>

<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>

<%
    boolean b = processDao.insertMember(bean);

    if(b){
        response.sendRedirect("list.jsp");
    } else {
        response.sendRedirect("fail.jsp");
    }
%>
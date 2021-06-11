<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 11.06.2021
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href='<c:url value="/user/list"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Lista Użytkowników</a>
    </div>
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div
                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
            </div>
            <!-- Card Body -->
            <div class="card-body shadow">
               <form class="form" method="post" action="<c:url value="/user/add"/>">
                   <div class="form-group">
                       <label for="userName">Nazwa</label>
                       <input class="form-control form-control-user bg-light" type="text" name="userName" id="userName" placeholder="Nazwa użytkownika">
                   </div>
                   <div class="form-group">
                       <label for="email">Email</label>
                       <input class="form-control form-control-user bg-light" type="email" name="email" id="email" placeholder="Email użytkownika">
                   </div>
                   <div class="form-group">
                       <label for="password">Hasło</label>
                       <input class="form-control form-control-user bg-light" type="password" name="password" id="password" placeholder="Hasło użytkownika">
                   </div>
                   <input type="submit" value="Zapisz" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
               </form>
            </div>
        </div>

</div>

</div>
<!-- End of Main Content -->

<%@ include file="/footer.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>List of Student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  </head>
  <body>
    <br>
    <div id="wrapper">
      <div id="header">
        <h2 class=display-4 style="margin-left: 170px;">Student Management</h2>
      </div>

    </div>
    <br><br>
    <div class="container">
      <div id="content">

        <table class=table table-bordered table-striped>
          <thead class="thead-dark">
            <tr>
              <th>S.No</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
          </thead>
          <c:forEach var="tempStudent" items="${studentsList}" >
            <c:url var="updateStudentLink" value="/student/editStudentDetails" >
              <c:param name="studentId" value="${tempStudent.id}" />
            </c:url>
            <c:url var="deleteStudentLink" value="/student/delete" >
              <c:param name="studentId" value="${tempStudent.id}" />
            </c:url>
            <tr>
              <td>${tempStudent.id}</td>
              <td>${tempStudent.firstName}</td>
              <td>${tempStudent.lastName}</td>
              <td>${tempStudent.email}</td>
              <td> <a href="${updateStudentLink}">Update</a> | <a href="${deleteStudentLink}">Delete</a> </td>
            </tr>
          </c:forEach>

        </table>
        <br>
          <a href="<c:url value = "/student/create"/>"><button class="btn btn-primary"></button>Create Student</a>
      </div>

    </div>

  </body>
</html>

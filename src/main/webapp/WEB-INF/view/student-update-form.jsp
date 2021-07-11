<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Student update form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  </head>
  <body>
    <br>
    <div class="container">
      <div id="header">
        <h2 class=display-5 style="margin-left: 2px;">Student Management</h2>
      </div>
      <hr>
      <div id="container">
        <br>
        <h3 class=display-5 style="margin-left: 2px;">Form to Update <span>${student.firstName}</span> Details</h3>
        <hr>
        <form:form class="" action="updateStudent" method="post" modelAttribute="student">
          <form:hidden path="id" />
          <table table table-bordered table-striped>
            <tbody>
              <tr>
                <td style="height:20px;"><label>Student First Name is:</label></td>
                <td style="height:20px;"><form:input size="50" path="firstName" /></td>
              </tr>
              <tr>
                <td style="height:20px;"><label>Student Last Name is:</label></td>
                <td style="height:20px;"><form:input size="50" path="lastName" /></td>
              </tr>
              <tr>
                <td style="height:20px;"><label>Student Email is:</label></td>
                <td style="height:20px;"><form:input size="50" path="email" /></td>
              </tr>
              <tr>
                <td style="height:20px;"><label></label></td>
                <td style="height:20px;"><button type="submit" value="Save" class="btn btn-info">Save</button></td>
              </tr>
            </tbody>
          </table>
        </form:form>
        <hr>

        </div>

          <a href="${pageContext.request.contextPath}/student/list" class="btn btn-primary">Back to Home Page</a>

      </div>
    </div>
  </body>
</html>

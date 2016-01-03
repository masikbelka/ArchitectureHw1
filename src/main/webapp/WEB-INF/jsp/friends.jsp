<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<h1>
    Hello
</h1>
<c:forEach var="friend" items="${friends}">
    ${friend.username}
    <br/>
    ${friend.name}
    <br/>
    ${friend.dateOfBirth}

</c:forEach>
</body>
</html>
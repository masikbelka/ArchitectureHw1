<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<h1>
    Hello
</h1>
<c:forEach var="note" items="${notes}">
    ${note.noteText}
    <br/>
    ${note.author}

</c:forEach>
 </body>
</html>
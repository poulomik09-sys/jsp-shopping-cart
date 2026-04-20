<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Your Cart</title>
</head>
<body>
<h2>Your Shopping Cart</h2>
<c:choose>
    <c:when test="${not empty cartItems}">
        <ul>
            <c:forEach var="item" items="${cartItems}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>Your cart is empty.</p>
    </c:otherwise>
</c:choose>
<br>
<a href="index.jsp">Continue Shopping</a>
</body>
</html>
//user submits the form then post /card then web.xml maps the /card to the cart servlet and then redirect to the /card. doGet method runs and forward to the cart.jsp

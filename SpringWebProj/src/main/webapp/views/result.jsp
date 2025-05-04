<%@page language="java" %>
<html>
<head> <link rel="stylesheet" type="text/css" href="style.css"> </head>
<body>
 <h2>My Calculator</h2>
 <label>The result : <%= session.getAttribute("result") %></label>
 <h4> Answer in JSTL: ${result}</h4>
  </body>
 </html>
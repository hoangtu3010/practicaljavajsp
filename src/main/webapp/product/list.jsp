<%@ page import="com.example.practicaljavajsp.entity.Product" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/table-custom.css">
    <title>List Products</title>
</head>
<body>
<div class="container">
    <h1>List Products</h1>
    <div class="d-flex justify-content-end mb-5">
        <a class="btn button-custom" href="/logout">Logout</a>
    </div>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Id</div>
            <div class="col col-2">Name</div>
            <div class="col col-2">Price</div>
            <div class="col col-3">Details</div>
            <div class="col col-2">Amount</div>
        </li>
        <%
            for (Product p : (List<Product>) request.getAttribute("listProducts")
            ) {
        %>
        <li class="table-row">
            <div class="col col-1"><%= p.getId() %></div>
            <div class="col col-2"><%= p.getName() %></div>
            <div class="col col-2"><%= "$" + p.getPrice() %></div>
            <div class="col col-3"><%= p.getDetails() %></div>
            <div class="col col-2"><%= p.getAmount() %></div>
        </li>
        <%
            }
        %>
    </ul>
</div>
</body>
</html>

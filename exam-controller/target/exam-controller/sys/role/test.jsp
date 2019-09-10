<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
</head>
<style>
    body {
        padding: 20px;
    }
    ul {
        list-style: none;
        margin: 5px 20px;
    }
    li {
        margin: 10px 0;
    }
</style>
<body>
<h1>Indeterminate Checkboxes</h1>

<ul>
    <%--<li>
        <input type="checkbox" name="tall" id="tall">
        <label for="tall">Tall Things</label>

        <ul>
            <li>
                <input type="checkbox" name="tall-1" id="tall-1">
                <label for="tall-1">Buildings</label>
            </li>
            <li>
                <input type="checkbox" name="tall-2" id="tall-2">
                <label for="tall-2">Giants</label>

                <ul>
                    <li>
                        <input type="checkbox" name="tall-2-1" id="tall-2-1">
                        <label for="tall-2-1">Andre</label>
                    </li>
                    <li>
                        <input type="checkbox" name="tall-2-2" id="tall-2-2">
                        <label for="tall-2-2">Paul Bunyan</label>
                    </li>
                </ul>
            </li>
            <li>
                <input type="checkbox" name="tall-3" id="tall-3">
                <label for="tall-3">Two sandwiches</label>
            </li>
        </ul>
    </li>--%>
    <li>
        <input type="checkbox" name="short" id="short">
        <label for="short">Short Things</label>

        <ul>
            <li>
                <input type="checkbox" name="short-1" id="short-1">
                <label for="short-1">Smurfs</label>
            </li>
            <li>
                <input type="checkbox" name="short-2" id="short-2">
                <label for="short-2">Mushrooms</label>
            </li>
            <li>
                <input type="checkbox" name="short-3" id="short-3">
                <label for="short-3">One Sandwich</label>
            </li>
        </ul>
    </li>
</ul>
<script type="text/javascript">
    $('input[type="checkbox"]').change(function(e) {

        var checked = $(this).prop("checked"),
            container = $(this).parent(),
            siblings = container.siblings();

        container.find('input[type="checkbox"]').prop({
            indeterminate: false,
            checked: checked
        });

        function checkSiblings(el) {

            var parent = el.parent().parent(),
                all = true;

            el.siblings().each(function() {
                let returnValue = all = ($(this).children('input[type="checkbox"]').prop("checked") === checked);
                return returnValue;
            });

            if (all && checked) {

                parent.children('input[type="checkbox"]').prop({
                    indeterminate: false,
                    checked: checked
                });

                checkSiblings(parent);

            } else if (all && !checked) {

                parent.children('input[type="checkbox"]').prop("checked", checked);
                parent.children('input[type="checkbox"]').prop("indeterminate", (parent.find('input[type="checkbox"]:checked').length > 0));
                checkSiblings(parent);

            } else {

                el.parents("li").children('input[type="checkbox"]').prop({
                    indeterminate: true,
                    checked: false
                });

            }

        }

        checkSiblings(container);
    });
</script>
</body>

</html>

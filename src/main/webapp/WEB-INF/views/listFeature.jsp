<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .custab {
        border: 1px solid #ccc;
        padding: 5px;
        margin: 5% 0;
        box-shadow: 3px 3px 2px #ccc;
        transition: 0.5s;
    }

    .custab:hover {
        box-shadow: 3px 3px 0px transparent;
        transition: 0.5s;
    }

    th {
        padding: 20px;
    }
</style>

<div class="row">
    <table class="table table-striped custab">
        <tr>
            <th>
                Feature Name
            </th>
            <th></th>
        </tr>


        <c:forEach items="${features}" var="feature">
            <tr>
                <td>${feature.featureName}</td>
                <td>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/feature/update/${feature.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>


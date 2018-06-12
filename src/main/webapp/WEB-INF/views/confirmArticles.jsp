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
                Title
            </th>
            <th>
                City
            </th>
            <th>
                District
            </th>
            <th>
                Address
            </th>
            <th>
                Area Size
            </th>
            <th>
                Price
            </th>
            <th>
                View
            </th>
            <th></th>
        </tr>


        <c:forEach items="${data.content}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.cityByCityId.cityName}</td>
                <td>${article.districtByDistrictId.districtName}</td>
                <td>${article.address}</td>
                <td>${article.areasize}</td>
                <td>${article.price}</td>
                <td>${article.view}</td>
                <td>
                    <a class="btn btn-warning activeArticle" aid="${article.id}">Confimr</a>
                    <%--@Html.ActionLink("Details", "Details", "Articles", new { id = item.Id }, new { @class = "btn btn-primary" })--%>
                </td>
            </tr>
        </c:forEach>

    </table>

    <div class="pagination-container">
        <ul class="pagination">
            <c:forEach begin="0" end="${data.totalPages-1}" varStatus="loop">
                <c:choose>
                    <c:when test="${currentPage == loop.index}">
                        <li class="active">
                            <a class="not-active" style="pointer-events: none;" href="${pageContext.request.contextPath}/article/list/?page=${loop.index}">${loop.index}</a>
                        </li>
                    </c:when>

                    <c:otherwise>
                        <li>
                            <a href="${pageContext.request.contextPath}/article/activeArticles/?page=${loop.index}">${loop.index}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </div>
</div>

<script>
    $(".activeArticle").click(function () {
        var del = $(this);
        if (confirm("Are you sure to active this article?")) {
            $.post("/realestate/article/activeArticle", { id: del.attr("aid") })
                .done(function (response) {
                        del.parent().parent().remove();
                });
        }
    });
</script>
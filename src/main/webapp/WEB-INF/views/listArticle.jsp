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
            <input id="article-id" type="hidden" value="${article.id}"/>
            <tr>
                <td>${article.title}</td>
                <td>${article.cityByCityId.cityName}</td>
                <td>${article.districtByDistrictId.districtName}</td>
                <td>${article.address}</td>
                <td>${article.areasize}</td>
                <td>${article.price}</td>
                <td>${article.view}</td>
                <td>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/article/update/${article.id}">Edit</a>
                    <c:choose>
                        <c:when test="${role='user'}">
                            <a id="delete-article" class="btn btn-danger" href="#">Delete</a>
                        </c:when>
                        <c:otherwise>
                            <a id="delete-article-admin" class="btn btn-danger" href="#">Delete</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

    </table>

    <script>
        $(document).ready(function(){
            $("#delete-article").click(function (){
                var articleId = $("#article-id").val();
                var del = $(this);
                if (confirm("Do you want to delete this article?")) {
                    $.post("/realestate/article/delete/"+articleId, { id: del.attr("aid") })
                        .done(function () {
                            del.parent().parent().remove();
                        });
                }
            });
            $("#delete-article-admin").click(function (){
                var articleId = $("#article-id").val();
                var del = $(this);
                if (confirm("Do you want to delete this article?")) {
                    $.post("/realestate/admin/article/delete/"+articleId, { id: del.attr("aid") })
                        .done(function () {
                            del.parent().parent().remove();
                        });
                }
            });
        });
    </script>

    <c:choose>
        <c:when test="${data.totalPages-1 > 0}">
            <div class="pagination-container">
                <ul class="pagination">
                    <c:forEach begin="0" end="${data.totalPages-1}" varStatus="loop">
                        <c:choose>
                            <c:when test="${currentPage == loop.index}">
                                <c:choose>
                                    <c:when test="${role=='user'}">
                                        <li class="active">
                                            <a class="not-active" style="pointer-events: none;" href="${pageContext.request.contextPath}/article/list/?page=${loop.index}">${loop.index}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="active">
                                            <a class="not-active" style="pointer-events: none;" href="${pageContext.request.contextPath}/admin/article/list/?page=${loop.index}">${loop.index}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>

                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${role=='user'}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/article/list/?page=${loop.index}">${loop.index}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/admin/article/list/?page=${loop.index}">${loop.index}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
        </c:when>
    </c:choose>
</div>
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
            <input id="feature-id" type="hidden" value="${feature.id}"/>
            <tr>
                <td>${feature.featureName}</td>
                <td>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/feature/update/${feature.id}">Edit</a>
                    <a id="delete-feature" class="btn btn-danger" href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

<script>
    $(document).ready(function(){
        $("#delete-feature").click(function (){
            var featureId = $("#feature-id").val();
            var del = $(this);
            if (confirm("Do you want to delete this feature?")) {
                $.post("/realestate/admin/feature/delete/"+featureId)
                    .done(function () {
                        del.parent().parent().remove();
                    });
            }
        });
    });
</script>

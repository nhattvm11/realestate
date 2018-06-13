<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post"  modelAttribute="feature" action="${pageContext.request.contextPath}/admin/feature/update/${feature.id}">
    <div class="form-horizontal">
        <h4>Update Feature</h4>
        <hr />

        <div class="form-group">
            <label class="control-label col-md-2">Feature Name</label>
            <div class="col-md-10">
                <form:input path="featureName" cssClass="form-control"/>
                <div class="text-danger" id="featureName-error"></div>
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Update</button>

    </div>

</form:form>
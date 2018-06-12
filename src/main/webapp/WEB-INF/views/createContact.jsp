<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post"  modelAttribute="contact" action="${pageContext.request.contextPath}/users/contact/create">
    <div class="form-horizontal">
        <h4>Create contact</h4>
        <hr />

        <div class="form-group">
            <label class="control-label col-md-2">Contact Name</label>
            <div class="col-md-10">
                <form:input path="contactName" cssClass="form-control"/>
                <div class="text-danger" id="contactName-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Phone</label>
            <div class="col-md-10">
                <form:input path="phone" cssClass="form-control"/>
                <div class="text-danger" id="phone-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Address</label>
            <div class="col-md-10">
                <form:input path="address" cssClass="form-control"/>
                <div class="text-danger" id="address-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Email</label>
            <div class="col-md-10">
                <form:input path="email" cssClass="form-control"/>
                <div class="text-danger" id="email-error"></div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Create</button>

    </div>

</form:form>
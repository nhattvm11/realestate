<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form id="formArticle" method="post"  modelAttribute="article" action="/realestate/article/create">

    <div class="form-horizontal">
        <h4>Article</h4>
        <hr />
        <div class="form-group">
            <label class = "control-label col-md-2">Type</label>
            <div class="col-md-10">
                <form:select path="typeId" items="${types}" cssClass="form-control"/>
                <div class="text-danger" id="typeId-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Property Type</label>
            <div class="col-md-10">
                <form:select path="propertyId" items="${propertyTypes}" cssClass="form-control"/>
                <div class="text-danger" id="property-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">City</label>
            <div class="col-md-10">
                <form:select path="cityId" items="${cities}" cssClass="form-control"/>
                <div class="text-danger" id="city-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">District</label>
            <div id="District" class="col-md-10">
                <select name="DistrictId" class = "form-control">
                    <option>--Select City--</option>
                </select>
            </div>
            <div class="text-danger" id="districtId-error"></div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Address</label>
            <div class="col-md-10">
                <form:input path="address" cssClass="form-control"/>
                <div class="text-danger" id="address-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Title</label>
            <div class="col-md-10">
                <form:input path="title" cssClass="form-control"/>
                <div class="text-danger" id="title-error"></div>
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.DateUp, htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10">--%>
                <%--@Html.JQueryUI().DatepickerFor(model => model.DateUp)--%>
                <%--@Html.ValidationMessageFor(model => model.DateUp, "", new { @class = "text-danger" })--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.DateExpire, htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10">--%>
                <%--@Html.JQueryUI().DatepickerFor(model => model.DateExpire)--%>
                <%--@Html.ValidationMessageFor(model => model.DateExpire, "", new { @class = "text-danger" })--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <label class="control-label col-md-2">Area Size</label>

            <div class="col-md-10">
                <form:input path="areasize" cssClass="form-control"/>
                <div class="text-danger" id="areasize-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">BedRoom</label>
            <div class="col-md-10">
                <form:input path="bedroom" cssClass="form-control"/>
                <div class="text-danger" id="bedroom-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">BathRoom</label>

            <div class="col-md-10">
                <form:input path="bathroom" cssClass="form-control"/>
                <div class="text-danger" id="bathroom-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Tiers</label>

            <div class="col-md-10">
                <form:input path="tier" cssClass="form-control"/>
                <div class="text-danger" id="tier-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Direction</label>

            <div class="col-md-10">
                <form:select path="directionId" items="${directions}" cssClass="form-control"/>
                <div class="text-danger" id="directionId-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Price</label>

            <div class="col-md-10">
                <form:input path="price" cssClass="form-control"/>
                <div class="text-danger" id="price-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Description</label>

            <div class="col-md-10">
                <form:textarea path="description" cssClass="form-control"/>
                <div class="text-danger" id="description-error"></div>
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.UserId, "UserId", htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10">--%>
                <%--@Html.DropDownList("UserId", null, htmlAttributes: new { @class = "form-control", @id = "ddlUser" })--%>
                <%--@Html.ValidationMessageFor(model => model.UserId, "", new { @class = "text-danger" })--%>
            <%--</div>--%>
        <%--</div>--%>


        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.ContactId, htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10" id="Contact">--%>
                <%--<select class="form-control" name="ContactId">--%>
                    <%--<option>--Select User before--</option>--%>
                <%--</select>--%>
                <%--@Html.ValidationMessageFor(model => model.ContactId, "", new { @class = "text-danger" })--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.Priority, htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10">--%>
                <%--@Html.EditorFor(model => model.Priority, new { htmlAttributes = new { @class = "form-control" } })--%>
                <%--@Html.ValidationMessageFor(model => model.Priority, "", new { @class = "text-danger" })--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.Active, htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10">--%>
                <%--<div class="checkbox">--%>
                    <%--@Html.EditorFor(model => model.Active)--%>
                    <%--@Html.ValidationMessageFor(model => model.Active, "", new { @class = "text-danger" })--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--@Html.LabelFor(model => model.View, htmlAttributes: new { @class = "control-label col-md-2" })--%>
            <%--<div class="col-md-10">--%>
                <%--@Html.EditorFor(model => model.View, new { htmlAttributes = new { @class = "form-control" } })--%>
                <%--@Html.ValidationMessageFor(model => model.View, "", new { @class = "text-danger" })--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <label class="control-label col-md-2">LivingRoom</label>

            <div class="col-md-10">
                <form:input path="livingroom" cssClass="form-control"/>
                <div class="text-danger" id="livingroom-error"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2">Features</label>
            <div class="col-md-10">
                <form:checkboxes element="li" path="features" items="${features}"/>
            </div>
        </div>

    </div>

</form:form>

<div class="container form-horizontal">
    <label class="control-label col-md-2">Images</label>
    <div class="panel panel-default col-md-10">
        <div class="panel-body">
            <div>
                <form id="dropzone-form" class="dropzone" action="/realestate/article/uploadImage"
                      enctype="multipart/form-data">

                    <div class="dz-default dz-message file-dropzone text-center well col-sm-12">
                        <span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
                        <span>Just Click</span>
                    </div>


                    <div class="dropzone-previews"></div>
                </form>
                <hr>
                <button id="upload-button" class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-plus"></span> Create Article
                </button>
            </div>
        </div>
    </div>
</div>


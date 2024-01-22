<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<h1>Form add phiếu giảm giá</h1>
<form:form method="post" modelAttribute="pgg" action="/phieu-giam-gia/viewAdd">
    <p>Mã phiếu: <form:input path="maphieu"/>
        <form:errors path="maphieu" cssClass="text-danger"/> </p>
    <p>Tên phiếu: <form:input path="tenphieu"/>
        <form:errors path="tenphieu" cssClass="text-danger"/> </p>
    <p>Giá trị giảm: <form:input path="giatrigiam"/>
    <form:errors path="giatrigiam" cssClass="text-danger"/></p>
    <p>Ngày bắt đầu: <form:input path="ngaybatdau"/>
        <form:errors path="ngaybatdau" cssClass="text-danger"/>
            ${errDate}
    </p>
    <p>Ngày kết thúc: <form:input path="ngayketthuc"/>
        <form:errors path="ngayketthuc" cssClass="text-danger"/></p>
    <p>Khách hàng:
        <form:select path="nguoisohuu">
            <option value="">-----</option>
            <form:options items="${dsKhachHang}"
                          itemLabel="tenkhachhang" itemValue="makhachhang"/>
        </form:select>
        <form:errors path="nguoisohuu" cssClass="text-danger"/>
    </p>
    <button>Add</button>
</form:form>

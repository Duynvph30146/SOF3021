<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="pgg">
    <p>Tên phiếu: <form:input path="tenphieu"/> <form:errors path="tenphieu"/> </p>
    <p>Giá trị giảm: <form:input path="giatrigiam"/> <form:errors path="giatrigiam"/></p>
    <p>Ngày bắt đầu: <form:input path="ngaybatdau"/>
        <form:errors path="ngaybatdau"/>${errDate}
    </p>
    <p>Ngày kết thúc: <form:input path="ngayketthuc"/> <form:errors path="ngayketthuc"/></p>
    <p>Khách hàng:
        <form:select path="nguoisohuu">
            <option value="">-----</option>
            <form:options items="${dsKhachHang}"
                itemLabel="tenkhachhang" itemValue="makhachhang"/>
        </form:select>
        <form:errors path="nguoisohuu"/>
    </p>
    <button>Cập nhật</button>
</form:form>

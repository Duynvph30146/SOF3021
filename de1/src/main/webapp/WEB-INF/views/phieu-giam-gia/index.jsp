<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<h1 class="text-center">Danh sách phiếu giảm giá</h1>
<table class="table table-hover table-bordered">
    <tr class="table-danger">
        <th>Mã phiếu</th>
        <th>Tên phiếu</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Giá trị giảm</th>
        <th>Trạng thái</th>
        <th>Người sở hữu</th>
        <th>Địa chỉ</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${page.content}" var="p">
        <tr>
            <td>${p.maphieu}</td>
            <td>${p.tenphieu}</td>
            <td>${p.ngaybatdau}</td>
            <td>${p.ngayketthuc}</td>
            <td>${p.giatrigiam}</td>
            <td>${p.trangthai?"Còn hiệu lực" : "Kết thúc"}</td>
            <td>${p.nguoisohuu.tenkhachhang}</td>
            <td>${p.nguoisohuu.diachi}</td>
            <td>
                <a href="/phieu-giam-gia/update/${p.maphieu}" class="btn btn-warning">Update</a>
                <a href="/phieu-giam-gia/delete/${p.maphieu}" class="btn btn-danger"
                   onclick="return confirm('Bạn có muốn xóa?')"
                >Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/phieu-giam-gia/viewAdd"><button class="btn btn-primary">Add</button></a>

<div class="text-center">
    <a href="/phieu-giam-gia/hien-thi">
        <button class="btn btn-primary">First</button>
    </a>
    <a href="/phieu-giam-gia/hien-thi?p=${page.number-1}">
        <button class="btn btn-primary">Prev</button>
    </a>
    <a href="/phieu-giam-gia/hien-thi?p=${page.number+1}">
        <button class="btn btn-primary">Next</button>
    </a>
    <a href="/phieu-giam-gia/hien-thi?p=${page.totalPages-1}">
        <button class="btn btn-primary">Last</button>
    </a>
</div>
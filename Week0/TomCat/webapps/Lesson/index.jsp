<%-- Thêm directive quan trọng này để đảm bảo EL (các thẻ ${...}) được xử lý --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin sinh viên - ${student.hoVaTen}</title>
    <link rel="stylesheet" href="styles/main.css">
    <%-- Thêm font từ Google Fonts cho đẹp hơn --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <div class="card">
        <div class="card-header">
            <h1>Thông Tin Sinh Viên</h1>
        </div>
        <div class="card-body">
            <div class="profile-section">
                <%-- Chỗ hiển thị ảnh của bạn --%>
                <div class="profile-pic">
                    <img src="images/id_photo.jpg" alt="Ảnh đại diện">
                </div>
                <div class="profile-info">
                    <p><strong>Họ và tên:</strong> ${student.hoVaTen}</p>
                    <p><strong>MSSV:</strong> ${student.maSoSinhVien}</p>
                    <p><strong>Ngày sinh:</strong> ${student.ngaySinh}</p>
                    <p><strong>Giới tính:</strong> ${student.gioiTinh}</p>
                    <p><strong>Lớp:</strong> ${student.lop}</p>
                    <p><strong>Môn học:</strong> ${student.monHoc}</p>
                    <p><strong>Mã học phần:</strong> ${student.maHocPhan}</p>
                </div>
            </div>

            <div class="assignments-section">
                <h2>Danh sách bài nộp</h2>
                <table class="assignment-table">
                    <thead>
                        <tr>
                            <th>Tuần</th>
                            <th>Link Github</th>
                            <th>Link Deploy (Render)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-- Vòng lặp để hiển thị danh sách bài tập --%>
                        <c:forEach var="asm" items="${student.assignments}">
                            <tr>
                                <td>${asm.tuan}</td>
                                <td><a href="${asm.githubLink}" target="_blank" class="btn btn-github">Mã nguồn</a></td>
                                <td><a href="${asm.renderLink}" target="_blank" class="btn btn-deploy">Sản phẩm</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
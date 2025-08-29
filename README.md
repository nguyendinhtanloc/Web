# Tổng hợp Bài tập Lập trình Web Java

Chào mừng bạn đến với kho lưu trữ các bài tập hàng tuần của tôi cho môn học Lập trình Web với Java. Mỗi thư mục trong đây là một dự án Maven độc lập, minh họa các khái niệm và kỹ thuật được học qua từng tuần.

---

## Thông tin tác giả

-   **Họ và tên**: Nguyễn Đình Tân Lộc
-   **Email**: `23133041@student.hcmute.edu.vn`

---

## Danh sách Bài tập

Dưới đây là tóm tắt các dự án đã thực hiện. Để xem chi tiết về cấu trúc, luồng hoạt động và hướng dẫn chạy của từng dự án, vui lòng truy cập vào link tương ứng.

| Tuần | Tên dự án | Mô tả ngắn | Link chi tiết |
| :---: | :--- | :--- | :---: |
| **00** | **Trang thông tin cá nhân** | Ứng dụng hiển thị thông tin sinh viên đọc từ file JSON. Tập trung vào mô hình MVC, Servlet, JSP và xử lý dữ liệu. | [Xem chi tiết](./Week0/) |
| **01** | **Ứng dụng đăng ký Email (Cơ bản)** | Xử lý form HTML đơn giản để đăng ký email. Minh họa luồng request-response và chuyển hướng (redirect). | [Xem chi tiết](./Week1/) |
| **02** | **Ứng dụng đăng ký Email (Nâng cao)** | Nâng cấp từ Tuần 1, thêm validation và xử lý dữ liệu phức tạp hơn. Tập trung vào chuyển tiếp (forward) request. | [Xem chi tiết](./Week2/) |



---

## Công nghệ chung

Các dự án trong kho lưu trữ này đều sử dụng một nền tảng công nghệ chung, bao gồm:

-   **Ngôn ngữ**: Java 11+
-   **Nền tảng**: Java Servlet & JavaServer Pages (JSP)
-   **Quản lý dự án**: Apache Maven
-   **Máy chủ web**: Apache Tomcat 9+

---

## Hướng dẫn chung

Mỗi thư mục con (`Week0`, `Week1`, `Week2`) là một dự án Maven hoàn chỉnh và độc lập.

1.  **Để build một dự án cụ thể**, hãy di chuyển vào thư mục của dự án đó và chạy lệnh:
    ```bash
    mvn clean package
    ```
2.  **Để triển khai**, sao chép file `.war` được tạo ra trong thư mục `target` vào thư mục `webapps` của Tomcat.
3.  **Để xem hướng dẫn chi tiết**, vui lòng tham khảo file `README.md` bên trong mỗi thư mục dự án.
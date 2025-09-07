# Ứng dụng Đăng ký Email (Nâng cao) - Email List Application v2

Đây là phiên bản nâng cấp của ứng dụng Java Web "Email List", cho phép người dùng đăng ký vào danh sách nhận tin bằng cách cung cấp họ tên, email và ngày sinh.

Dự án tiếp tục minh họa luồng xử lý cơ bản của một ứng dụng web: từ form nhập liệu có validation đơn giản, xử lý logic ở backend bằng Servlet, và chuyển hướng đến trang xác nhận thông tin.

---

## Công nghệ & Môi trường

Dự án được xây dựng và vận hành với các công nghệ và công cụ sau:

-   **Ngôn ngữ**: Java 11+
-   **Build tool**: Apache Maven
-   **Máy chủ**: Apache Tomcat 9+
-   **IDE gợi ý**: IntelliJ IDEA, Eclipse, hoặc VS Code (với Extension Pack for Java)

### Thư viện sử dụng

-   **Java Servlet API**: Để xử lý các yêu cầu HTTP từ người dùng.
-   **JavaServer Pages (JSP) API**: Để tạo giao diện người dùng động.

---

## Cấu trúc dự án

Dự án tuân theo cấu trúc chuẩn của một Maven Web Application, đảm bảo sự tách biệt rõ ràng giữa logic, giao diện và tài nguyên.

Week2/
├── pom.xml
└── src/
└── main/
├── java/
│   └── murach/
│       └── email/
│           ├── User.java
│           └── EmailListServlet.java
├── resources/
└── webapp/
├── WEB-INF/
│   └── web.xml
├── styles/
│   └── main.css
├── index.jsp
└── thanks.jsp
**Giải thích các thành phần chính:**

| File / Thư mục      | Chức năng                                                               |
| ------------------- | ----------------------------------------------------------------------- |
| `User.java`         | **Model**: Đại diện cho thông tin người dùng (firstName, lastName, email, dateOfBirth). |
| `EmailListServlet.java` | **Controller**: Nhận, kiểm tra (validate) và xử lý dữ liệu từ form, sau đó chuyển hướng. |
| `web.xml`           | Cấu hình deployment, ánh xạ URL `/emailList` tới `EmailListServlet`.  |
| `index.jsp`         | **View**: Chứa form HTML để người dùng nhập thông tin cá nhân.                  |
| `thanks.jsp`        | **View**: Trang cảm ơn, hiển thị lại thông tin người dùng đã nhập sau khi đăng ký thành công. |
| `styles/main.css`   | Định dạng giao diện (CSS) cho các trang JSP.                             |
| `pom.xml`           | Quản lý các thư viện (dependencies) và cấu hình build của dự án.        |

---

## Luồng hoạt động của ứng dụng

Ứng dụng hoạt động theo một luồng request-response tiêu chuẩn:

1.  **Nhập liệu**: Người dùng truy cập `index.jsp` và điền thông tin vào form, bao gồm họ tên, email và ngày sinh.
2.  **Gửi yêu cầu**: Khi nhấn nút "Sign Up", form sẽ gửi một HTTP POST request đến `EmailListServlet`.
3.  **Xử lý & Validation**: `EmailListServlet` nhận dữ liệu, kiểm tra tính hợp lệ (ví dụ: các trường không được để trống), tạo một đối tượng `User`, và đặt đối tượng này vào `request scope`.
4.  **Chuyển tiếp (Forward)**: Servlet chuyển tiếp yêu cầu (thay vì chuyển hướng) đến trang `thanks.jsp`, mang theo cả đối tượng `request` và `response`.
5.  **Hiển thị kết quả**: `thanks.jsp` sử dụng Expression Language (`${...}`) để lấy thông tin từ đối tượng `user` trong `request` và hiển thị lời chào mừng cùng thông tin đã đăng ký.



---

## Hướng dẫn chạy

Để triển khai và chạy ứng dụng trên máy của bạn, hãy làm theo các bước sau:

1.  **Clone dự án về máy:**

    ```bash
    git clone <your-repository-url>
    cd Week2
    ```

2.  **Build dự án bằng Maven:**
    Mở Terminal tại thư mục gốc của dự án và chạy lệnh:
    ```bash
    mvn clean package
    ```
    Lệnh này sẽ biên dịch code, chạy các kiểm thử (nếu có), và đóng gói ứng dụng thành một file `.war` trong thư mục `target`.

3.  **Triển khai trên Tomcat:**
    -   Sao chép file `Lesson.war` (hoặc tên tương tự) từ thư mục `target` vào thư mục `webapps` của Tomcat.
    -   Khởi động Tomcat. Máy chủ sẽ tự động giải nén và triển khai ứng dụng của bạn.
    -   Truy cập vào trình duyệt theo địa chỉ: `http://localhost:8080/Lesson/` (tên context path thường trùng với tên file `.war`).

---

## Lưu ý quan trọng

-   Đảm bảo các file Java nằm trong đúng package: `src/main/java/murach/email/`.
-   Các tài nguyên web (JSP, CSS) phải nằm trong `src/main/webapp/`.
-   File `web.xml` là bắt buộc để Tomcat có thể nhận diện và ánh xạ URL tới Servlet một cách chính xác.

---

##  Tác giả

-   **Họ và tên**: Nguyễn Đình Tân Lộc
-   **Email**: `23133041@student.hcmute.edu.vn`
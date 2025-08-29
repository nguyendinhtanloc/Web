# Ứng dụng quản lý danh sách email - Email List Application

Một dự án Java Web cơ bản giúp người dùng nhập thông tin (họ tên, email) và đăng ký vào danh sách nhận tin. Ứng dụng này minh họa luồng xử lý cốt lõi của một ứng dụng web: từ trang nhập liệu (form), xử lý logic ở backend (Servlet), và cuối cùng là chuyển hướng đến trang xác nhận.

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

Dự án tuân theo cấu trúc chuẩn của một Maven Web Application:
Week1/
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
| `User.java`         | **Model**: Đại diện cho thông tin người dùng (firstName, lastName, email). |
| `EmailListServlet.java` | **Controller**: Nhận và xử lý dữ liệu từ form, sau đó chuyển hướng. |
| `web.xml`           | Cấu hình deployment, ánh xạ URL `/emailList` tới `EmailListServlet`.  |
| `index.jsp`         | **View**: Chứa form HTML để người dùng nhập thông tin.                  |
| `thanks.jsp`        | **View**: Trang cảm ơn, hiển thị sau khi người dùng đăng ký thành công. |
| `styles/main.css`   | Định dạng giao diện (CSS) cho các trang JSP.                             |
| `pom.xml`           | Quản lý các thư viện (dependencies) và cấu hình build của dự án.        |

---

##  Luồng hoạt động của ứng dụng

Ứng dụng hoạt động theo một luồng request-response đơn giản:

1.  **Nhập liệu**: Người dùng truy cập vào trang `index.jsp` và điền thông tin vào form đăng ký.
2.  **Gửi yêu cầu**: Khi nhấn nút "Sign Up", form sẽ gửi một HTTP POST request đến `EmailListServlet`.
3.  **Xử lý**: `EmailListServlet` nhận dữ liệu, tạo một đối tượng `User`, và thực hiện các logic cần thiết (ví dụ: lưu vào cơ sở dữ liệu, ở đây chỉ đơn giản là chuyển tiếp).
4.  **Chuyển hướng**: Servlet sau đó gửi một lệnh chuyển hướng (redirect) đến trình duyệt, yêu cầu truy cập trang `thanks.jsp`.
5.  **Hiển thị kết quả**: Trình duyệt nhận lệnh và tải trang `thanks.jsp`, hiển thị thông báo đăng ký thành công cho người dùng.


---

##  Hướng dẫn chạy

Để triển khai và chạy ứng dụng trên máy của bạn, hãy làm theo các bước sau:

1.  **Clone dự án về máy:**

    ```bash
    git clone <your-repository-url>
    cd Week1
    ```

2.  **Build dự án bằng Maven:**
    Mở Terminal hoặc Command Prompt tại thư mục gốc của dự án và chạy lệnh:
    ```bash
    mvn clean package
    ```
    Lệnh này sẽ tạo ra một file `Week1.war` trong thư mục `target`.

3.  **Triển khai trên Tomcat:**
    -   Sao chép file `Week1.war` vừa tạo vào thư mục `webapps` của Tomcat.
    -   Khởi động Tomcat. Máy chủ sẽ tự động giải nén và triển khai ứng dụng.
    -   Truy cập vào trình duyệt theo địa chỉ: `http://localhost:8080/Week1/`

---

## Lưu ý quan trọng

-   Đảm bảo các file Java nằm trong đúng package: `src/main/java/murach/email/`.
-   Các tài nguyên web (JSP, CSS, images) phải nằm trong `src/main/webapp/`.
-   File `web.xml` là bắt buộc trong dự án này để Tomcat có thể nhận diện và ánh xạ URL tới Servlet.

---

## Tác giả

-   **Họ và tên**: Nguyễn Đình Tân Lộc
-   **Email**: `23133041@student.hcmute.edu.vn`
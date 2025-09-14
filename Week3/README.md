# Ứng dụng Đăng ký Khảo sát

Đây là phiên bản nâng cao của ứng dụng Java Web, minh họa các kỹ thuật xử lý form phức tạp, tái sử dụng giao diện với JSP Includes, và luồng điều khiển MVC (Model-View-Controller) cơ bản sử dụng Servlet và JSP.

Dự án cho phép người dùng đăng ký thông tin cá nhân và sở thích qua một form khảo sát. Dữ liệu sau đó được xử lý ở backend và hiển thị lại để xác nhận.

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

Week3/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── murach/
        │       ├── business/
        │       │   └── User.java
        │       └── email/
        │           └── EmailListServlet.java
        └── webapp/
            ├── WEB-INF/
            │   └── web.xml
            ├── includes/
            │   ├── header.html
            │   └── footer.jsp
            ├── styles/
            │   └── main.css
            ├── index.jsp
            └── thanks.jsp

**Giải thích các thành phần chính:**

 File / Thư mục          | Chức năng |
|--------------------------|-----------|
| **User.java**            | **Model**: Đại diện cho thông tin người dùng, bao gồm các trường phức hợp như lựa chọn (radio), checkbox. |
| **EmailListServlet.java** | **Controller**: Xử lý cả request **GET** (hiển thị form) và **POST** (xử lý dữ liệu). Chịu trách nhiệm lấy năm hiện tại và xử lý encoding. |
| **web.xml**              | **Deployment descriptor**: Cấu hình deployment, ánh xạ URL `/emailList` tới `EmailListServlet`. |
| **index.jsp**            | **View**: Chứa form HTML để người dùng nhập thông tin. Tái sử dụng `header.html` và `footer.jsp`. |
| **thanks.jsp**           | **View**: Trang cảm ơn, hiển thị lại toàn bộ thông tin người dùng đã nhập. Tái sử dụng `header.html` và `footer.jsp`. |
| **includes/header.html** | **UI Component**: Chứa phần đầu của trang HTML (metadata, CSS link, header). |
| **includes/footer.jsp**  | **UI Component**: Chứa phần chân trang và hiển thị năm bản quyền một cách tự động. |
| **styles/main.css**      | **CSS**: Định dạng giao diện cho các trang JSP. |
| **pom.xml**              | **Build & Dependencies**: Quản lý các thư viện (dependencies) và cấu hình build của dự án Maven. |

---

# Luồng hoạt động của ứng dụng

## Các bước xử lý

1. **Truy cập lần đầu**  
   - Người dùng truy cập trang chủ.  
   - Request **GET** được gửi đến `EmailListServlet`.

2. **Xử lý GET**  
   - Servlet lấy năm hiện tại.  
   - Đặt giá trị năm vào **request scope**.  
   - Forward request đến `index.jsp`.

3. **Hiển thị Form**  
   - `index.jsp` được hiển thị.  
   - Trang này bao gồm `header.html` và `footer.jsp` (footer hiển thị năm hiện tại).

4. **Gửi dữ liệu**  
   - Người dùng nhập thông tin vào form.  
   - Nhấn **Submit** → gửi một request **POST** chứa dữ liệu form đến `EmailListServlet`.

5. **Xử lý POST**  
   Servlet thực hiện các công việc:
   - Thiết lập **UTF-8 encoding** để xử lý tiếng Việt chính xác.  
   - Đọc tất cả tham số từ form (text, radio, checkbox, select).  
   - Tạo một đối tượng **User** và điền đầy đủ thông tin.  
   - Đặt đối tượng `user` và `currentYear` vào **request scope**.  
   - Forward request đến `thanks.jsp`.

6. **Hiển thị kết quả**  
   - `thanks.jsp` sử dụng **Expression Language** (`${...}`) để lấy thông tin từ đối tượng `user`.  
   - Hiển thị lại toàn bộ thông tin cho người dùng xác nhận.


---

## Hướng dẫn chạy

Để triển khai và chạy ứng dụng trên máy của bạn, hãy làm theo các bước sau:

1.  **Clone dự án về máy:**

    ```bash
    git clone <your-repository-url>
    cd Week3
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
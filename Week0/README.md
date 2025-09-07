# Trang web thông tin cá nhân - Student Profile Page

Dự án Java Web đơn giản hiển thị thông tin cá nhân và danh sách bài tập của một sinh viên. Dữ liệu được đọc động từ một file `student.json`, minh họa cho việc tách biệt giữa dữ liệu (Model), logic điều khiển (Controller) và giao diện hiển thị (View).

---

## Công nghệ & Môi trường

Dự án được xây dựng với các công nghệ và công cụ sau:

- **Java Development Kit (JDK)**: Phiên bản 1.8 hoặc cao hơn
- **Apache Maven**: Quản lý thư viện và build dự án
- **Apache Tomcat**: Máy chủ web để triển khai ứng dụng (phiên bản 9+)
- **IDE gợi ý**: IntelliJ IDEA, Eclipse hoặc VS Code với plugin Java
- **Thư viện Java**:
    - `javax.servlet-api`: Servlet API
    - `javax.servlet.jsp-api`: JSP API
    - `jstl`: JavaServer Pages Standard Tag Library
    - `Gson`: Thư viện của Google để xử lý JSON

---

## Cấu trúc dự án

Dự án tuân theo cấu trúc chuẩn của một Maven Web Application:
Week0/
├─ pom.xml
└─ src/
└─ main/
├─ java/
│  └─ vn/loc/
│     ├─ controller/
│     │  └─ ProfileServlet.java
│     └─ model/
│        ├─ Assignment.java
│        └─ Student.java
├─ resources/
│  └─ student.json
└─ webapp/
├─ WEB-INF/
│  └─ web.xml (Tùy chọn nếu dùng @WebServlet)
├─ images/
│  └─ id_photo.jpg
├─ styles/
│  └─ main.css
└─ index.jsp

**Giải thích:**

| File / Thư mục | Chức năng |
|---|---|
| `Student.java` | **Model**: Lưu trữ thông tin cá nhân của sinh viên. |
| `Assignment.java` | **Model**: Lưu trữ thông tin của một bài nộp hàng tuần. |
| `ProfileServlet.java` | **Controller**: Đọc dữ liệu từ `student.json`, chuyển đổi thành đối tượng Java và gửi tới `index.jsp`. |
| `student.json` | **Data Source**: File chứa toàn bộ thông tin tĩnh của sinh viên, hoạt động như một cơ sở dữ liệu đơn giản. |
| `index.jsp` | **View**: Giao diện chính, nhận dữ liệu từ Servlet và hiển thị thông tin sinh viên, ảnh đại diện và danh sách bài nộp. |
| `main.css` | File CSS để định dạng giao diện cho trang web. |
| `id_photo.jpg` | Ảnh đại diện của sinh viên. |
| `pom.xml` | File cấu hình Maven, quản lý các thư viện cần thiết cho dự án. |

---

## Luồng hoạt động của ứng dụng

1.  Người dùng truy cập vào URL gốc của ứng dụng (ví dụ: `http://localhost:8080/Lesson/`).
2.  Tomcat nhận yêu cầu và chuyển đến `ProfileServlet` (do được map với URL `""` qua annotation `@WebServlet`).
3.  `ProfileServlet` được khởi tạo, phương thức `init()` sẽ đọc file `student.json` từ `resources` và dùng thư viện Gson để chuyển dữ liệu thành đối tượng `Student`.
4.  Servlet đặt đối tượng `student` này vào `request scope`.
5.  Servlet chuyển tiếp (forward) yêu cầu cùng với dữ liệu tới `index.jsp`.
6.  `index.jsp` sử dụng Expression Language (`${...}`) và JSTL (`<c:forEach>`) để đọc dữ liệu từ đối tượng `student` và render ra trang HTML hoàn chỉnh, sau đó gửi về cho trình duyệt của người dùng.

---

## Hướng dẫn chạy

1.  **Clone project về máy:**

    ```bash
    git clone <your-repository-url>
    cd Week0
    ```

2.  **Build project bằng Maven:**
    Mở Terminal hoặc Command Prompt tại thư mục gốc của dự án và chạy lệnh:
    ```bash
    mvn clean package
    ```
    Lệnh này sẽ tạo ra một file `Lesson.war` trong thư mục `target`.

3.  **Triển khai trên Tomcat:**
    -   Sao chép file `Lesson.war` vừa tạo vào thư mục `webapps` của Tomcat.
    -   Khởi động Tomcat. Máy chủ sẽ tự động giải nén và triển khai ứng dụng.
    -   Truy cập vào trình duyệt theo địa chỉ: `http://localhost:8080/Lesson/`

---

### Tác giả

Họ và tên: Nguyễn Đình Tân Lộc

Email: 23133041@student.hcmute.edu.vn
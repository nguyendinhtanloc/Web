# Email List Application

Ứng dụng Java Web đơn giản cho phép người dùng đăng ký vào một danh sách email.  
Dự án minh họa luồng xử lý cơ bản của ứng dụng web: từ form nhập liệu, xử lý backend bằng Servlet, đến trang xác nhận đăng ký.

---

## Công nghệ & Môi trường

- **Java Development Kit (JDK)** 11 trở lên  
- **Apache Maven**: quản lý dependencies và build project  
- **Apache Tomcat**: máy chủ web để triển khai ứng dụng  
- **IDE gợi ý**: IntelliJ IDEA, Eclipse hoặc VS Code (có plugin Java)  
- **Trình duyệt**: Chrome, Firefox, Edge  

---

## Cấu trúc dự án

Dự án theo chuẩn Maven Web:

- Week2/src/main/java/murach/...
- Week2/target/...
- Week2/TomCat/...
- pom.xml
- README.md


**Giải thích:**

| File | Chức năng |
|------|-----------|
| `User.java` | Model lưu thông tin người dùng (name, email, ngày sinh) |
| `EmailListServlet.java` | Xử lý form gửi email và redirect sang `thanks.jsp` |
| `web.xml` | Cấu hình servlet và URL mapping |
| `index.jsp` | Form nhập thông tin người dùng |
| `thanks.jsp` | Trang hiển thị lời cảm ơn |
| `styles/main.css` | CSS định dạng giao diện |

---

## Flow ứng dụng

1. Người dùng truy cập **index.jsp** và nhập thông tin (tên, email, ngày sinh).  
2. Nhấn **Sign Up** → dữ liệu gửi tới `EmailListServlet`.  
3. Servlet xử lý dữ liệu, tạo đối tượng `User`, lưu thông tin, và redirect tới **thanks.jsp**.  
4. **thanks.jsp** hiển thị thông báo cảm ơn và xác nhận thông tin đã nhập.

---

## Hướng dẫn chạy

1. **Clone project về máy:**

```bash
git clone <repo-url>
cd Week2
```

2. **Build project bằng Maven:**
```bash
mvn clean package
```

3. **Triển khai trên Tomcat:**
- Sao chép file Lesson.war vào thư mục webapps của Tomcat.
- Khởi động Tomcat, Tomcat sẽ tự động giải nén và triển khai ứng dụng.
- Truy cập trình duyệt: `http://localhost:8080/Lesson`

---

### Lưu ý quan trọng

- Các file Java phải nằm trong đúng package: src/main/java/murach.
- File JSP và CSS phải nằm trong src/main/webapp/.
- File web.xml phải ở WEB-INF/ để Tomcat nhận diện và ánh xạ Servlet.

---

### Tác giả

Họ và tên: Nguyễn Đình Tấn Lộc

Email: 23133041@student.hcmute.edu.vn

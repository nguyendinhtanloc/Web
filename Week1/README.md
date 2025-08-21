# Ứng dụng quản lý danh sách email - Email List Application

Dự án Java Web đơn giản giúp người dùng nhập thông tin và đăng ký vào một danh sách email.  
Ứng dụng minh họa luồng xử lý cơ bản của một ứng dụng web: từ trang nhập liệu (form), xử lý dữ liệu ở backend (Servlet), đến trang xác nhận cuối cùng.

---

## Công nghệ & Môi trường

Dự án được xây dựng với các công nghệ và công cụ sau:

- **Java Development Kit (JDK)**: Phiên bản 11 hoặc cao hơn  
- **Apache Maven**: Quản lý dependencies và build project  
- **Apache Tomcat**: Máy chủ web để triển khai ứng dụng  
- **IDE gợi ý**: IntelliJ IDEA, Eclipse hoặc VS Code với plugin Java  
- **Trình duyệt**: Chrome, Firefox hoặc Edge  

---

## Cấu trúc dự án

Dự án tuân theo chuẩn Maven Web:


Week1/
├─ pom.xml
└─ src/
└─ main/
├─ java/
│ └─ murach/email/
│ ├─ User.java
│ └─ EmailListServlet.java
├─ resources/
└─ webapp/
├─ WEB-INF/
│ └─ web.xml
├─ styles/
│ └─ main.css
├─ index.jsp
└─ thanks.jsp


**Giải thích:**

| File | Chức năng |
|------|-----------|
| `User.java` | Model lưu thông tin người dùng (name, email) |
| `EmailListServlet.java` | Xử lý form gửi email và redirect sang `thanks.jsp` |
| `web.xml` | Cấu hình servlet và URL mapping |
| `index.jsp` | Form nhập thông tin người dùng |
| `thanks.jsp` | Trang hiển thị lời cảm ơn |
| `styles/main.css` | CSS định dạng giao diện |

---

## Flow ứng dụng

1. Người dùng truy cập **index.jsp** và điền tên cùng email vào form.  
2. Nhấn **Sign Up** → dữ liệu được gửi tới `EmailListServlet`.  
3. `EmailListServlet` xử lý dữ liệu (tạo đối tượng `User`, lưu thông tin, …), sau đó redirect tới **thanks.jsp**.  
4. **thanks.jsp** hiển thị thông báo cảm ơn và xác nhận đăng ký thành công.
---

## Hướng dẫn chạy

1. **Clone project về máy:**

```bash
git clone <repo-url>
cd Week1
```

2. **Build project bằng Maven:**
```
mvn clean package
```

3. **Triển khai trên Tomcat:**
- Sao chép file Week1.war vào thư mục webapps của Tomcat.
- Khởi động Tomcat, Tomcat sẽ tự động giải nén và triển khai ứng dụng.
- Truy cập trình duyệt: `http://localhost:8080/Week1`

---

### Lưu ý quan trọng

- Các file Java phải nằm trong đúng package: src/main/java/murach/email/.
- File JSP và CSS phải nằm trong src/main/webapp/.
- File web.xml phải ở WEB-INF/ để Tomcat nhận diện và ánh xạ Servlet.

---

### Tác giả

Họ và tên: Nguyễn Đình Tân Lộc

Email: 23133041@student.hcmute.edu.vn

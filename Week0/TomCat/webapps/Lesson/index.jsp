<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${profile.fullName} | Portfolio</title>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=Poppins:wght@500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>

<div class="container">
    <header class="hero">
        <button id="toggle-theme" title="Chuyển chế độ sáng/tối"><i class="fas fa-adjust"></i></button>
        <img src="images/avatar.jpg" alt="Ảnh đại diện" class="hero-avatar">
        <h1>${profile.fullName}</h1>
        <h2>${profile.headline}</h2>
        <p class="hero-bio">${profile.bio}</p>
        <div class="hero-socials">
            <c:forEach var="social" items="${profile.socials}">
                <a href="${social.link}" target="_blank" title="${social.name}"><i class="${social.icon}"></i></a>
            </c:forEach>
        </div>
    </header>

    <section class="about-me-section content-card">
        <h2><i class="fas fa-user-circle"></i> Về Tôi</h2>
        <p>${profile.aboutMe}</p>
    </section>

    <section class="education-section content-card">
        <h2><i class="fas fa-graduation-cap"></i> Học Vấn</h2>
        <div class="education-entry">
            <div class="education-details">
                <h3 class="education-school">${profile.education.school}</h3>
                <p class="education-major"><strong>Chuyên ngành:</strong> ${profile.education.major}</p>
                <p class="education-years"><strong>Niên khóa:</strong> ${profile.education.years}</p>
            </div>
        </div>
    </section>
    
    <section class="activity-section content-card">
        <h2><i class="fas fa-rocket"></i> Hoạt động & Cộng đồng</h2>
        <div class="activity-entry">
            <div class="activity-details">
                <h3 class="activity-name">HCM UTE Research on Technology and Innovation Club (RTIC)</h3>
                <p class="activity-role"><strong>Vai trò:</strong> Thành viên Ban Truyền Thông</p>
                <p class="activity-description">
                    Là thành viên Ban Truyền Thông, tôi chịu trách nhiệm xây dựng hình ảnh và kết nối CLB với cộng đồng sinh viên. Công việc bao gồm sáng tạo nội dung, thiết kế ấn phẩm và tham gia tổ chức, quảng bá các sự kiện công nghệ của CLB.
                </p>
                <div class="activity-skills">
                    <strong class="skills-category">Kỹ năng đạt được:</strong>
                    <div class="skills-grid-small">
                        <span class="tech-tag">Sáng tạo Nội dung</span>
                        <span class="tech-tag">Thiết kế (Canva, Figma)</span>
                        <span class="tech-tag">Quản lý Mạng xã hội</span>
                        <span class="tech-tag">Tổ chức Sự kiện</span>
                        <span class="tech-tag">Làm việc nhóm</span>
                        <span class="tech-tag">Giao tiếp</span>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="skills-section content-card">
        <h2><i class="fas fa-laptop-code"></i> Kỹ năng</h2>
        <div class="skills-grid">
            <c:forEach var="skill" items="${profile.skills}">
                <span class="tech-tag">${skill}</span>
            </c:forEach>
        </div>
    </section>

    <main class="projects-section">
        <h2>Danh sách bài tập</h2>
        <div class="projects-grid">
            <c:forEach var="project" items="${profile.projects}">
                <div class="project-card">
                    <h3>${project.projectName}</h3>
                    <p class="project-description">${project.description}</p>
                    <div class="project-tech">
                        <c:forEach var="tech" items="${project.technologies}">
                            <span class="tech-tag">${tech}</span>
                        </c:forEach>
                    </div>
                    <div class="project-links">
                        <a href="${project.githubLink}" target="_blank" class="btn btn-github"><i class="fab fa-github"></i> Mã nguồn</a>
                        <c:if test="${not empty project.demoLink}">
                            <a href="${project.demoLink}" target="_blank" class="btn btn-deploy"><i class="fas fa-rocket"></i> Sản phẩm</a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>

    <footer class="footer">
        <p>&copy; ${currentYear} ${profile.fullName}. Liên hệ: <a href="mailto:${profile.email}">${profile.email}</a></p>
    </footer>
</div>

<script src="https://unpkg.com/typeit@8.7.0/dist/index.umd.js"></script>
<script src="https://unpkg.com/scrollreveal"></script>
<script src="scripts/script.js"></script>

</body>
</html>
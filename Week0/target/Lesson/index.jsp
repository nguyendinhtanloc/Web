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
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>

<div class="container">
    <header class="hero">
        <img src="images/avatar.jpg" alt="Ảnh đại diện" class="hero-avatar">
        <h1>${profile.fullName}</h1>
        <h2>${profile.headline}</h2>
        <p class="hero-bio">${profile.bio}</p>
        <div class="hero-socials">
            <c:forEach var="social" items="${profile.socials}">
                <a href="${social.link}" target="_blank" title="${social.name}">
                    <i class="${social.icon}"></i>
                </a>
            </c:forEach>
        </div>
    </header>

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
                        <a href="${project.githubLink}" target="_blank" class="btn btn-github">
                            <i class="fab fa-github"></i> Mã nguồn
                        </a>
                        <c:if test="${not empty project.demoLink}">
                            <a href="${project.demoLink}" target="_blank" class="btn btn-deploy">
                                <i class="fas fa-rocket"></i> Sản phẩm
                            </a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>

    <footer class="footer">
        <p>&copy; 2025 ${profile.fullName}. Liên hệ: <a href="mailto:${profile.email}">${profile.email}</a></p>
    </footer>
</div>

</body>
</html>
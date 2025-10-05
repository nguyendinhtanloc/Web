document.addEventListener("DOMContentLoaded", () => {
    // 1. Dark Mode Toggle
    const toggleBtn = document.getElementById("toggle-theme");
    toggleBtn.addEventListener("click", () => {
        document.body.classList.toggle("dark-mode");
    });

    // 2. Typing Effect for Headline
    const headlineElement = document.querySelector('.hero h2');
    if (headlineElement && typeof TypeIt !== 'undefined') {
        new TypeIt(headlineElement, {
            strings: [headlineElement.textContent, "Java Enthusiast", "Problem Solver"],
            speed: 75,
            waitUntilVisible: true,
            cursor: true,
            cursorSpeed: 1000,
            loop: true,
            breakLines: false
        }).go();
    }

    // 3. Scroll Reveal Animations
    if (typeof ScrollReveal !== 'undefined') {
        const sr = ScrollReveal({
            origin: 'bottom',
            distance: '60px',
            duration: 1000,
            delay: 200,
            reset: false // Animation chỉ chạy 1 lần
        });

        sr.reveal('.hero', { origin: 'top' });
        sr.reveal('.skills-section', { delay: 300 });
        sr.reveal('.projects-section h2');
        sr.reveal('.project-card', { interval: 150 }); // Hiệu ứng lần lượt cho các card
        sr.reveal('.footer', { distance: '30px', delay: 200 });
    }
});
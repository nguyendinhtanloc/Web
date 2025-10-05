package murach.util;

// Dòng import này không còn cần thiết cho việc so sánh nữa, có thể xóa đi.
// import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {


    public static String hashPassword(String plainTextPassword) {
        return null; // Trả về null vì hiện tại không dùng
    }

    /**
     * (ĐÃ SỬA) So sánh trực tiếp mật khẩu người dùng nhập vào
     * với mật khẩu văn bản gốc lấy từ database.
     * @param plainTextPassword Mật khẩu người dùng gõ vào form.
     * @param passwordFromDB Mật khẩu (dạng plaintext) lấy từ database.
     * @return true nếu hai mật khẩu khớp nhau, ngược lại false.
     */
    public static boolean checkPassword(String plainTextPassword, String passwordFromDB) {
        // Bỏ logic BCrypt.checkpw(...)
        // Thay bằng phép so sánh chuỗi trực tiếp.
        return plainTextPassword.equals(passwordFromDB);
    }
    
}


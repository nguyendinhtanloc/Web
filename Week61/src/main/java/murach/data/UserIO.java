// Khai báo package, giúp tổ chức và quản lý các lớp trong dự án.
package murach.data;

// Import các thư viện cần thiết cho việc xử lý file (java.io) và các cấu trúc dữ liệu (java.util).
import java.io.*;
import java.util.*;

// Import lớp User từ package murach.business để có thể sử dụng.
import murach.business.User;

/**
 * Lớp UserIO chịu trách nhiệm cho các hoạt động đọc và ghi dữ liệu
 * của đối tượng User vào một tệp tin.
 */
public class UserIO {
    
    /**
     * Ghi thông tin của một đối tượng User vào một dòng mới ở cuối tệp.
     * @param user Đối tượng User cần ghi.
     * @param filename Tên của tệp tin để ghi dữ liệu vào.
     * @throws IOException Ném ra ngoại lệ nếu có lỗi trong quá trình ghi tệp.
     */
    public static void addRecord(User user, String filename)
    throws IOException {
        // Tạo một đối tượng PrintWriter để ghi dữ liệu văn bản vào tệp.
        // new FileWriter(filename, true) mở tệp ở chế độ "append" (ghi tiếp vào cuối),
        // tham số 'true' đảm bảo dữ liệu mới không ghi đè lên dữ liệu cũ.
        PrintWriter out = new PrintWriter(new FileWriter(filename, true));
        
        // Ghi một dòng mới vào tệp. Dòng này chứa các thuộc tính của đối tượng user,
        // mỗi thuộc tính được ngăn cách bởi ký tự "|".
        out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName() + "|" +
            user.getHeardFrom() + "|" + user.getUpdates() + "|" + user.getContactVia());
            
        // Đóng luồng ghi. Đây là bước quan trọng để đảm bảo tất cả dữ liệu được ghi vào tệp
        // và giải phóng tài nguyên hệ thống.
        out.close();
    }   
    
    /**
     * Đọc tất cả dữ liệu người dùng từ một tệp tin và trả về một danh sách (ArrayList) các đối tượng User.
     * @param fileName Tên của tệp tin cần đọc.
     * @return Một ArrayList chứa các đối tượng User đã được đọc từ tệp.
     * @throws IOException Ném ra ngoại lệ nếu có lỗi trong quá trình đọc tệp.
     */
    public static ArrayList<User> getUsers(String fileName) 
        throws IOException {
            // Khởi tạo một ArrayList rỗng để lưu trữ các đối tượng User.
            ArrayList<User> users = new ArrayList<>();
            
            // Tạo một đối tượng BufferedReader để đọc tệp một cách hiệu quả (đọc theo từng dòng).
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            
            // Đọc dòng đầu tiên của tệp.
            String line = in.readLine();

            // Bắt đầu vòng lặp để đọc từng dòng trong tệp.
            // Vòng lặp sẽ tiếp tục cho đến khi readLine() trả về null (khi đã đọc hết tệp).
            while (line != null) {
                // Sử dụng StringTokenizer để tách chuỗi 'line' thành các phần (tokens)
                // dựa trên ký tự phân cách "|".
                StringTokenizer t = new StringTokenizer(line, "|");
                
                // Lấy từng token theo đúng thứ tự đã ghi và gán vào các biến.
                String email = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                String heardFrom = t.nextToken();
                String updates = t.nextToken();
                String contactVia = t.nextToken();

                // Tạo một đối tượng User mới từ các thông tin vừa đọc được.
                User user = new User(email, firstName, lastName, heardFrom, updates, contactVia);
                
                // Thêm đối tượng User vừa tạo vào danh sách.
                users.add(user);
                
                // Đọc dòng tiếp theo trong tệp để chuẩn bị cho lần lặp kế tiếp.
                line = in.readLine();
            }

            // Đóng luồng đọc để giải phóng tài nguyên.
            in.close();
            
            // Trả về danh sách chứa tất cả các đối tượng User.
            return users;
        }
}
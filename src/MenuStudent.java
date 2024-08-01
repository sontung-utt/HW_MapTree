import java.util.*;

public class MenuStudent {
    StudentManager studentManager = new StudentManager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMenuStudent() {
        int choice;
        do {
            System.out.println("==========Quản lý sinh viên==========");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo Id");
            System.out.println("5. Danh sách sinh viên theo tên gần đúng");
            System.out.println("6. Sinh viên có điểm trung bình cao nhất");
            System.out.println("7. Hiển thị tất cả sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    menuAddStudent();
                    break;
                case 2:
                    menuEditStudent();
                    break;
                case 3:
                    menuRemoveStudent();
                    break;
                case 4:
                    menuGetStudent();
                    break;
                case 5:
                    menuGetStudentByName();
                    break;
                case 6:
                    menuGetMaxAvgScore();
                    break;
                case 7:
                    menuGetAllStudent();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void menuAddStudent() {
        System.out.println("=====Thêm mới sinh viên=====");
        System.out.print("Nhập tên sinh viên: ");
        String name = inputString.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = inputString.nextLine();
        double math, literature, english;
        do {
            System.out.print("Nhập điểm toán: ");
            math = inputNumber.nextDouble();
            System.out.print("Nhập điểm văn: ");
            literature = inputNumber.nextDouble();
            System.out.print("Nhập điểm anh: ");
            english = inputNumber.nextDouble();
            if (!checkMark(math, literature, english)) {
                System.out.println("Điểm không hợp lệ! Yêu cầu nhập lại.");
            }
        } while (!checkMark(math, literature, english));

        Student student = new Student(name, gender, math, literature, english);
        studentManager.saveStudent(student);
        System.out.println("Thêm sinh viên thành công!");
    }

    public void menuEditStudent() {
        System.out.println("=====Sửa thông tin sinh viên=====");
        System.out.print("Nhập mã sinh viên muốn sửa: ");
        int idEdit = inputNumber.nextInt();
        if (studentManager.checkId(idEdit)) {
            System.out.print("Nhập tên sinh viên: ");
            String name = inputString.nextLine();
            System.out.print("Nhập giới tính: ");
            String gender = inputString.nextLine();
            double math, literature, english;
            do {
                System.out.print("Nhập điểm toán: ");
                math = inputNumber.nextDouble();
                System.out.print("Nhập điểm văn: ");
                literature = inputNumber.nextDouble();
                System.out.print("Nhập điểm anh: ");
                english = inputNumber.nextDouble();
                if (!checkMark(math, literature, english)) {
                    System.out.println("Điểm không hợp lệ! Yêu cầu nhập lại.");
                }
            } while (!checkMark(math, literature, english));
            Student student = new Student(idEdit, name, gender, math, literature, english);
            studentManager.saveStudent(student);
            System.out.println("Sửa thông tin sinh viên thành công!");
        } else {
            System.out.println("Không tồn tại mã sinh viên " + idEdit + "!");
        }
    }

    private boolean checkMark(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a > 10 || b > 10 || c > 10) {
            return false;
        } else {
            return true;
        }
    }

    public void menuRemoveStudent() {
        System.out.println("=====Xóa sinh viên=====");
        System.out.print("Nhập mã sinh viên muốn xóa: ");
        int idRemove = inputNumber.nextInt();
        if (studentManager.checkId(idRemove)) {
            studentManager.removeStudent(idRemove);
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tồn tại mã sinh viên " + idRemove + "!");
        }
    }

    public void menuGetStudent() {
        System.out.println("=====Tìm kiếm sinh viên theo Id=====");
        System.out.print("Nhập mã sinh viên muốn tìm kiếm: ");
        int id = inputNumber.nextInt();
        if (!studentManager.checkId(id)) {
            System.out.println("Không có mã sinh viên " + id);
        } else {
            System.out.println(studentManager.getStudentById(id));
        }
    }

    public void menuGetStudentByName() {
        System.out.println("=====Danh sách sinh viên theo tên gần đúng=====");
        System.out.print("Nhập tên sinh viên: ");
        String name = inputString.nextLine();
        Map<Integer, Student> list = studentManager.getStudentByName(name);
        Set<Integer> keys = list.keySet();
        if (list.isEmpty()) {
            System.out.println("Không có sinh viên nào có tên gần đúng với " + name);
        } else {
            for (Integer key : keys) {
                System.out.println(list.get(key));
            }
        }
    }

    public void menuGetAllStudent() {
        System.out.println("=====Danh sách sinh viên=====");
        Map<Integer, Student> students = studentManager.getAllStudent();
        Set<Integer> keys = students.keySet();
        for (Integer key : keys) {
            System.out.println(students.get(key));
        }
    }

    public void menuGetMaxAvgScore() {
        System.out.println("=====Sinh viên có điểm trung bình cao nhất=====");
        System.out.println(studentManager.getMaxAvgScore());
    }
}

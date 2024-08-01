import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentManager {
    private final Map<Integer, Student> students ;

    public StudentManager(){
        this.students = new HashMap<>();
    }

    public void saveStudent(Student student){
        students.put(student.getId(), student);
    }

    public boolean checkId (int id){
        return students.containsKey(id);
    }

    public void removeStudent (int id) {
        students.remove(id);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public Map<Integer, Student> getAllStudent (){
        return students;
    }

    public Student getMaxAvgScore (){
        double maxAvgScore = 0;
        Student topStudent = null;
        Set<Integer> studentIds = students.keySet();
        for (Integer key : studentIds) {
            if(students.get(key).getAvgScore() > maxAvgScore){
                maxAvgScore = students.get(key).getAvgScore();
                topStudent = students.get(key);
            }
        }
        return topStudent;
    }

    public Map<Integer, Student> getStudentByName(String name) {
        Map<Integer, Student> list = new HashMap<>();
        Set<Integer> keys = students.keySet();
        for (Integer key : keys){
           if(students.get(key).getName().toLowerCase().contains(name.toLowerCase())){
               list.put(key, students.get(key));
           }
        }
        return list;
    }

}

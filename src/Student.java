public class Student {
    private int id;
    private String name;
    private String gender;
    private double scoreMath;
    private double scoreLiterature;
    private double scoreEnglish;

    private static int idIncrement = 1;

    public Student() {
    }

    public Student(String name, String gender, double scoreMath, double scoreLiterature, double scoreEnglish) {
        this.id = idIncrement;
        this.name = name;
        this.gender = gender;
        this.scoreMath = scoreMath;
        this.scoreLiterature = scoreLiterature;
        this.scoreEnglish = scoreEnglish;
        idIncrement ++;
    }

    public Student(int id, String name, String gender, double scoreMath, double scoreLiterature, double scoreEnglish) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.scoreMath = scoreMath;
        this.scoreLiterature = scoreLiterature;
        this.scoreEnglish = scoreEnglish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(double scoreMath) {
        this.scoreMath = scoreMath;
    }

    public double getScoreLiterature() {
        return scoreLiterature;
    }

    public void setScoreLiterature(double scoreLiterature) {
        this.scoreLiterature = scoreLiterature;
    }

    public double getScoreEnglish() {
        return scoreEnglish;
    }

    public void setScoreEnglish(double scoreEnglish) {
        this.scoreEnglish = scoreEnglish;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Student.idIncrement = idIncrement;
    }

    public double getAvgScore(){
        return (scoreMath + scoreLiterature + scoreEnglish) / 3;
    }

    public String toString() {
        return "Mã sinh viên: " + id +
                "\nTên sinh viên: " + name +
                "\nGiới tính: " + gender +
                "\nĐiểm Toán: " + scoreMath +
                "\nĐiểm Văn: " + scoreLiterature +
                "\nĐiểm Anh: " + scoreEnglish +
                "\nĐiểm trung bình: " + getAvgScore();
    }
}

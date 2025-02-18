package academic.model;

/**
 * @author 12S23023 Lenni Febriyani Hutape
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */
public class Course {
    private String code;
    private String name;
    private int credit;
    private String grade;
    
    public Course(String code, String name, int credit, String grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getCode() { return code; }

    public String getName() { return name; }

    public int getCredit() { return credit; }

    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credit + "|" + grade;
    }
}

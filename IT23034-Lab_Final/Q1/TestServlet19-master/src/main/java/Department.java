public class Department {
    private String deptName;
    private int totalStudent;
    public Department() {
    }
    public Department(String deptName, int totalStudent) {
        this.deptName = deptName;
        this.totalStudent = totalStudent;
    }
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }
    @Override
    public String toString() {
        return "Department [Name=" + deptName + ", Students=" + totalStudent + "]";
    }
}
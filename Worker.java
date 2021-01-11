public class Worker {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private Integer pay;
    private Integer age;

    public Worker() {
    }

    public Worker(String fullName, String position, String email, String phoneNumber, Integer pay, Integer age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pay = pay;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void printPerson(){
        System.out.printf("Сотрудник: %s, Должности: %s, Почта: %s, Телефон: %s, Зарплата: %d ТУГ(риков), Возраст: %d лет.\n", this.fullName, this.position, this.email, this.phoneNumber, this.pay, this.age);
    }


}

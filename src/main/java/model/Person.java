package model;

/**
 * 员工
 */
public class Person {

    //职位
    private String title;


    public Person(){}

    public Person(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

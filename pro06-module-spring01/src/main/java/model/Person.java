package model;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class Person {
    private Integer id;
    private String name;
    private Wife wife;
    private Data data;
    private List<String> hobbies;
    private Map<Integer,String> course;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public Person(Integer id, String name, Wife wife, Data data, List<String> hobbies, Map<Integer, String> course) {
        this.id = id;
        this.name = name;
        this.wife = wife;
        this.data = data;
        this.hobbies = hobbies;
        this.course = course;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wife=" + wife +
                ", data=" + data +
                ", hobbies=" + hobbies +
                ", course=" + course +
                '}';
    }
}

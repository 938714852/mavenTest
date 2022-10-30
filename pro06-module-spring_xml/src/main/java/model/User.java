package model;

public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
        
    }

    public Integer getId() {
        return id;
    }
    //基于setter方法的依赖注入 对应set方法的名字
    //比如 setId()  -->  name="id"  setXxx  -> name ="Xxx"  即对应set方法名后面的名字
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Teacher implements Person {
    String  id;
    String name;

    @Override
    public String getId() {
        return id;
    }

//    String compare
    @Override
    public int compareTo(Object o) {
//        return id.compareTo((String) o);
        return id.compareTo(((Person) o).getId());
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

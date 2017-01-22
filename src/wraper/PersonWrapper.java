package wraper;



/**
 * Created by vertex0007 on 21.01.2017.
 */
public class PersonWrapper {

    private Person person;

   public  PersonWrapper(Person person) {
        this.person = person;
    }
public PersonWrapper(int id, String name) {
    person = new Person.Builder()
            .setId(id)
            .setName(name)
            .getInstance();
}
    public String getStringId() {
        return Integer.toString(person.getId());
    }
    public String getNameInUpperCase() {
        return person.getName().toUpperCase();
    }
    public int idValue() {
        return person.getId();
    }
    public String nameValue() {
        return person.getName();
    }
}

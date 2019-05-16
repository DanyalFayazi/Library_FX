package sample;

public class wt {
    private String name;
    private String family;
    private String id;
    private boolean permission=false;

    public wt(String name, String family, String id) {
        this.name = name;
        this.family = family;
        this.id = id;
    }
    public wt() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

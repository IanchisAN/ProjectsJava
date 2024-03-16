package isp.lab7.safehome;

import java.util.Objects;

public class Tenant {

    private final Long id;
    private String name;
    private static Long currentId = 0L;

    public Tenant() {
        this.id = currentId++;
    }

    public Tenant(String name) {
        this.id = currentId++;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((Tenant)o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

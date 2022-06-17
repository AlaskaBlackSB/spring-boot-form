package com.example.springbootform.models.domain;

public class Role {
    private Integer id;
    private String name;
    private String role;

    public Role() {

    }

    public Role(Integer id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {

        Role role = (Role) obj;

        // Comprueba que <obj> sea una instancia de Role
        if (!(obj instanceof Role)) {
            return false;
        }

        // Compara la instancia del objeto con la del objeto que se recibe
        if (this == obj) {
            return true;
        }

        return this.id != null && this.id.equals(role.getId());
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}
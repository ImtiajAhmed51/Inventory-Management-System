package imtiaj.model;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refId;

    //bi-directional many-to-one association to Permission
    @ManyToOne
    private Permission permission;

    //bi-directional many-to-one association to Role
    @ManyToOne
    private Role role;

    public RolePermission() {
    }

    public int getRefId() {
        return this.refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
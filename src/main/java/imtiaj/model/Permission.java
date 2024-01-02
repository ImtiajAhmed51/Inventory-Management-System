package imtiaj.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    private String permissionName;

    //bi-directional many-to-one association to RolePermission
    @OneToMany(mappedBy = "permission")
    private List<RolePermission> rolePermissions;

    public Permission() {
    }

    public int getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<RolePermission> getRolePermissions() {
        return this.rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public RolePermission addRolePermission(RolePermission rolePermission) {
        getRolePermissions().add(rolePermission);
        rolePermission.setPermission(this);

        return rolePermission;
    }

    public RolePermission removeRolePermission(RolePermission rolePermission) {
        getRolePermissions().remove(rolePermission);
        rolePermission.setPermission(null);

        return rolePermission;
    }

}
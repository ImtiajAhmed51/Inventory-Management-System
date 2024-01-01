package imtiaj.model;
import javax.persistence.*;


/**
 * The persistent class for the permission_log database table.
 * 
 */
@Entity
@Table(name="permission_log")
public class PermissionLogEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int permissionId;

	private String permissionName;

	public PermissionLogEntity() {
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

}
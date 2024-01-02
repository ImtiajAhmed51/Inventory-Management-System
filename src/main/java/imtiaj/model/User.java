package imtiaj.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @Column(name = "CreatedUser")
    private String createdUser;

    @Column(name = "LastModifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    @Column(name = "LastModifiedUser")
    private String lastModifiedUser;

    @Column(name = "userAddress")
    private String userAddress;

    @Column(name = "userContactNumber")
    private BigDecimal userContactNumber;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userFname")
    private String userFname;

    @Column(name = "userLname")
    private String userLname;

    @Column(name = "userName")
    private String userName;

    @Column(name = "VERSION")
    private BigDecimal version;

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //bi-directional many-to-one association to UserRole
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    public User() {
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getLastModifiedDateTime() {
        return this.lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public String getUserAddress() {
        return this.userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public BigDecimal getUserContactNumber() {
        return this.userContactNumber;
    }

    public void setUserContactNumber(BigDecimal userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFname() {
        return this.userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return this.userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public List<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserRole addUserRole(UserRole userRole) {
        getUserRoles().add(userRole);
        userRole.setUser(this);

        return userRole;
    }

    public UserRole removeUserRole(UserRole userRole) {
        getUserRoles().remove(userRole);
        userRole.setUser(null);

        return userRole;
    }

}
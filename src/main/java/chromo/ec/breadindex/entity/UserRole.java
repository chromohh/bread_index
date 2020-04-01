package chromo.ec.breadindex.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Enumerated(EnumType.STRING)
    private UserRoleEnums roleName;

    public UserRole(){}

    public UserRole(UserRoleEnums roleName){
        this.roleName = roleName;
    }

    public UserRoleEnums getUserRoleName() {
        return roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRole{");
        sb.append("roleId=").append(roleId);
        sb.append(", userRoleName=").append(roleName);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return roleId == userRole.roleId &&
                Objects.equals(roleName, userRole.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }
}

package bz.sunlight.auth.bean;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;


/**
 * UserRoleDto
 * Created by chen_yong on 2017/6/21.
 */
@Entity
@Table(name = "user_roles")
public class UserRoleDto implements Serializable {
  private UUID userId;
  private UUID roleId;

  @Id
  @Type(type = "uuid-char")
  @Column(name = "user_id")
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  @Basic
  @Type(type = "uuid-char")
  @Column(name = "role_id")
  public UUID getRoleId() {
    return roleId;
  }

  public void setRoleId(UUID roleId) {
    this.roleId = roleId;
  }
}

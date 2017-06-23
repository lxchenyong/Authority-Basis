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
 * PermissionsDto
 * Created by chen_yong on 2017/6/21.
 */
@Entity
@Table(name = "permissions")
public class PermissionsDto implements Serializable {
  private UUID roleId;
  private UUID operationId;
  private UUID tenantId;

  @Id
  @Type(type = "uuid-char")
  @Column(name = "role_id")
  public UUID getRoleId() {
    return roleId;
  }

  public void setRoleId(UUID roleId) {
    this.roleId = roleId;
  }

  @Basic
  @Type(type = "uuid-char")
  @Column(name = "operation_id")
  public UUID getOperationId() {
    return operationId;
  }

  public void setOperationId(UUID operationId) {
    this.operationId = operationId;
  }

  @Basic
  @Type(type = "uuid-char")
  @Column(name = "tenant_id")
  public UUID getTenantId() {
    return tenantId;
  }

  public void setTenantId(UUID tenantId) {
    this.tenantId = tenantId;
  }
}

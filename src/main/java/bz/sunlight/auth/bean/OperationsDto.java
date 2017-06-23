package bz.sunlight.auth.bean;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.UUID;


/**
 * OperationsDto
 * Created by chen_yong on 2017/6/20.
 */
@Entity
@Table(name = "operations")
public class OperationsDto implements Serializable {
  private UUID id;
  private String code;
  private String name;
  private UUID resourceId;

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Basic
  @Column(name = "code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Type(type = "uuid-char")
  @Column(name = "resource_id")
  public UUID getResourceId() {
    return resourceId;
  }

  public void setResourceId(UUID resourceId) {
    this.resourceId = resourceId;
  }
}

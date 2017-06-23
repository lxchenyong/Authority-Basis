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
 * OperationHttpDto
 * Created by chen_yong on 2017/6/21.
 */
@Entity
@Table(name = "operation_http")
public class OperationHttpDto implements Serializable {
  private UUID id;
  private UUID operationId;
  private String httpVerb;
  private String resourcePath;

  @Id
  @GeneratedValue
  @Type(type = "uuid-char")
  @Column(name = "id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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
  @Column(name = "http_verb")
  public String getHttpVerb() {
    return httpVerb;
  }

  public void setHttpVerb(String httpVerb) {
    this.httpVerb = httpVerb;
  }

  @Basic
  @Column(name = "resource_path")
  public String getResourcePath() {
    return resourcePath;
  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }
}

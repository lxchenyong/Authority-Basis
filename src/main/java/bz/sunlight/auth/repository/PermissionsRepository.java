package bz.sunlight.auth.repository;

import bz.sunlight.auth.bean.PermissionsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * PermissionsRepository
 * Created by chen_yong on 2017/6/21.
 */
public interface PermissionsRepository extends JpaRepository<PermissionsDto, UUID> {

  @Query("SELECT pd FROM PermissionsDto pd WHERE pd.operationId =:operationId AND pd.roleId in (:roleIds)")
  PermissionsDto findPermissionsById(@Param("operationId") UUID operationId,
                                     @Param("roleIds") List<UUID> roleIds);
}

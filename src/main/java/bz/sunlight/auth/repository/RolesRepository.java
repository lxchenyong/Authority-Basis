package bz.sunlight.auth.repository;

import bz.sunlight.auth.bean.RoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * RolesRepository
 * Created by chen_yong on 2017/6/21.
 */
public interface RolesRepository extends JpaRepository<RoleDto, UUID> {

  @Query("SELECT rd FROM RoleDto rd WHERE rd.id in (:roleIds)")
  List<RoleDto> findRoleAllByRoleId(@Param("roleIds") List<UUID> roleIds);
}

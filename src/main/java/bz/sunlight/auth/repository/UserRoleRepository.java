package bz.sunlight.auth.repository;

import bz.sunlight.auth.bean.UserRoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * UserRoleRepository
 * Created by chen_yong on 2017/6/21.
 */
public interface UserRoleRepository extends JpaRepository<UserRoleDto, UUID> {

  @Query("SELECT ur.roleId FROM UserRoleDto ur WHERE ur.userId =:userId")
  List<UUID> findRoleIdByUserId(@Param("userId") UUID userId);
}

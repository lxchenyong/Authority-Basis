package bz.sunlight.auth.service;

import bz.sunlight.auth.bean.RoleDto;

import java.util.List;
import java.util.UUID;


/**
 * OperationService
 * Created by chen_yong on 2017/6/20.
 */
public interface OperationService {

  /**
   * 根据http请求查询出OperationId.
   *
   * @param method 请求方法
   * @param path   url
   * @return 返回operationId
   */
  UUID findOperationId(String method, String path);

  /**
   * 根据userID 查询出所有的roleId.
   *
   * @param userId 用户id
   * @return 返回所有的roleId
   */
  List<UUID> findRoleIdByUserId(UUID userId);

  /**
   * 根据operationId和roleIds查询出权限.
   *
   * @param operationId 操作id
   * @param roleIds     角色 id
   * @return 查看是否有权限
   */
  boolean findPermissions(UUID operationId, List<UUID> roleIds);

  /**
   * 根据roleId 得到所有角色.
   *
   * @param roleIds 角色id
   * @return 返回所有角色
   */
  List<RoleDto> findRoleByRoleId(List<UUID> roleIds);
}

package bz.sunlight.auth.service.impl;

import bz.sunlight.auth.bean.PermissionsDto;
import bz.sunlight.auth.bean.RoleDto;
import bz.sunlight.auth.repository.OperationHttpRepository;
import bz.sunlight.auth.repository.PermissionsRepository;
import bz.sunlight.auth.repository.RolesRepository;
import bz.sunlight.auth.repository.UserRoleRepository;
import bz.sunlight.auth.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;


/**
 * OperationServiceImpl
 * Created by chen_yong on 2017/6/20.
 */
@Service
public class OperationServiceImpl implements OperationService {

  private OperationHttpRepository operationHttpRepository;
  private PermissionsRepository permissionsRepository;
  private RolesRepository rolesRepository;
  private UserRoleRepository userRoleRepository;

  /**
   * 初始化这些 Repository.
   *
   * @param operationHttpRepository 操作API
   * @param permissionsRepository   权限
   * @param rolesRepository         角色
   * @param userRoleRepository      用户与角色关联操作
   */
  @Autowired
  public OperationServiceImpl(OperationHttpRepository operationHttpRepository,
                              PermissionsRepository permissionsRepository,
                              RolesRepository rolesRepository,
                              UserRoleRepository userRoleRepository) {
    this.operationHttpRepository = operationHttpRepository;
    this.permissionsRepository = permissionsRepository;
    this.rolesRepository = rolesRepository;
    this.userRoleRepository = userRoleRepository;
  }

  @Override
  public UUID findOperationId(String method, String path) {
    return operationHttpRepository.findOperationIdByHttp(method, path);
  }

  @Override
  public List<UUID> findRoleIdByUserId(UUID userId) {
    return userRoleRepository.findRoleIdByUserId(userId);
  }

  @Override
  public boolean findPermissions(UUID operationId, List<UUID> roleIds) {
    PermissionsDto permissionsDto = permissionsRepository.findPermissionsById(operationId, roleIds);
    return !StringUtils.isEmpty(permissionsDto);
  }

  @Override
  public List<RoleDto> findRoleByRoleId(List<UUID> roleIds) {
    return rolesRepository.findRoleAllByRoleId(roleIds);
  }
}

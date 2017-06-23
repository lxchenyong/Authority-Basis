package bz.sunlight.auth.controller;

import bz.sunlight.auth.bean.RoleDto;
import bz.sunlight.auth.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


/**
 * AuthorityController
 * Created by chen_yong on 2017/6/20.
 */
@RestController
public class AuthorityController {

  private OperationService operationService;

  @Autowired
  public AuthorityController(OperationService operationService) {
    this.operationService = operationService;
  }

  /**
   * 判断是否有访问API权限.
   * 1、根据请求的method和path得到operationId
   * 2、根据userId得到所有roleIds
   * 3、根据roleIds和operationId来查看是否有权限
   *
   * @param method 请求方法
   * @param path   url
   * @param userId 用户id
   * @return 返回是否有权限
   */
  @GetMapping(value = "/test")
  public boolean isPermissions(@RequestParam(value = "method", required = false) String method,
                               @RequestParam(value = "path", required = false) String path,
                               @RequestParam(value = "userId", required = false) UUID userId) {
    method = "POST";
    path = "/api/v1/orders";
    userId = UUID.fromString("4f29fde6-9b6b-4805-9f44-2d3f18940324");

    UUID operationId = operationService.findOperationId(method, path);
    List<UUID> roleIds = operationService.findRoleIdByUserId(userId);
    System.out.println("operationIds=" + operationId + "\n size= " + roleIds.size());
    return operationService.findPermissions(operationId, roleIds);
  }

  /**
   * 该用户名下的所有角色.
   * 1、根据userId得到roleIds
   * 2、根据roleIds得到所有角色
   *
   * @param userId 用户id
   * @return 返回所有角色
   */
  @GetMapping(value = "/test2")
  public List<RoleDto> getRoles(@RequestParam(value = "userId", required = false) UUID userId) {
    userId = UUID.fromString("4f29fde6-9b6b-4805-9f44-2d3f18940324");
    List<UUID> roleIds = operationService.findRoleIdByUserId(userId);
    System.out.println("operationIds=\n size= " + roleIds.size());
    return operationService.findRoleByRoleId(roleIds);
  }
}

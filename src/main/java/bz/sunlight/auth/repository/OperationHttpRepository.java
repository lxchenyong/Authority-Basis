package bz.sunlight.auth.repository;

import bz.sunlight.auth.bean.OperationHttpDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;


/**
 * OperationHRepository
 * Created by chen_yong on 2017/6/21.
 */
public interface OperationHttpRepository extends JpaRepository<OperationHttpDto, UUID> {
  @Query("SELECT oh.operationId FROM OperationHttpDto oh WHERE oh.httpVerb =:method AND oh.resourcePath= :path")
  UUID findOperationIdByHttp(@Param("method") String method, @Param("path") String path);
}

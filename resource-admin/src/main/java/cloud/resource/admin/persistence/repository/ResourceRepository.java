package cloud.resource.admin.persistence.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cloud.resource.admin.persistence.entity.ResourceEntity;


public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
//    Page<ResourceEntity> findByUsername(String username, Pageable page);
	 @Query(value = "SELECT menuid  FROM resource_entity ", nativeQuery = true)
	 List listall();
	 
	 
	  
//	    //根据手机号  账号查找出相应账号  1表示存在 >=1表示不存在
//	    @Query(value = "SELECT 1 FROM tab_register WHERE cellphone=?1 OR act=?1 ", nativeQuery = true)
//	    int getActIsExistByCellPhone(String cellphone);
//
//	    //新增一条（注册）
//	    @Query(value = "INSERT IGNORE INTO tab_register (cellphone,psd) VALUES (?1, ?2)", nativeQuery = true)
//	    @Modifying
//	    int insertRegisterModelOne(String cellphone, String psd);
//
//	    //登录
//	    @Query(value = "SELECT * FROM tab_register WHERE  cellphone=?1 AND psd=?2 ", nativeQuery = true)
//	    RegisterModel loginAct(String act, String psd);
//
//	    //修改密码
//	    @Query(value = "UPDATE tab_register SET psd=?2 WHERE id=?1", nativeQuery = true)
//	    @Modifying
//	    int upDateActPsdById(Integer id, String psd);
//
//	    //删除账号
//	    @Query(value = "DELETE FROM tab_register WHERE id=?1", nativeQuery = true)
//	    @Modifying
//	    int delAct(Integer id);
//
//	 @Query("SELECT m FROM Misaka m WHERE m.id>4")
//	    Page<Misaka> search(Pageable pageable);
}
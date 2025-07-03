//不可修改，重复生成会覆盖
package cn.iocoder.yudao.module.demo.service.contact;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.demo.controller.admin.contact.vo.*;
import cn.iocoder.yudao.module.demo.dal.dataobject.contact.ContactDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * demo联系人 AutoService 接口
 *
 * @author 芋道源码
 */
public interface ContactAutoService {

    /**
     * 创建demo联系人
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createContact(@Valid ContactSaveReqVO createReqVO);

    /**
     * 更新demo联系人
     *
     * @param updateReqVO 更新信息
     */
    void updateContact(@Valid ContactSaveReqVO updateReqVO);

    /**
     * 删除demo联系人
     *
     * @param id 编号
     */
    void deleteContact(Long id);

    /**
    * 批量删除demo联系人
    *
    * @param ids 编号
    */
    void deleteContactListByIds(List<Long> ids);

    /**
     * 获得demo联系人
     *
     * @param id 编号
     * @return demo联系人
     */
    ContactDO getContact(Long id);

    /**
     * 获得demo联系人分页
     *
     * @param pageReqVO 分页查询
     * @return demo联系人分页
     */
    PageResult<ContactDO> getContactPage(ContactPageReqVO pageReqVO);

}
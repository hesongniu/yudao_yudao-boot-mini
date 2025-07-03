//不可修改，重复生成会覆盖
package cn.iocoder.yudao.module.demo.service.contact;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.demo.controller.admin.contact.vo.*;
import cn.iocoder.yudao.module.demo.dal.dataobject.contact.ContactDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.demo.dal.mysql.contact.ContactMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.demo.enums.ErrorCodeConstants.*;

/**
 * demo联系人 AutoService 实现类
 *
 * @author 芋道源码
 */
//@Service
@Validated
public class ContactAutoServiceImpl implements ContactAutoService {

    @Resource
    private ContactMapper contactMapper;

    @Override
    public Long createContact(ContactSaveReqVO createReqVO) {
        // 插入
        ContactDO contact = BeanUtils.toBean(createReqVO, ContactDO.class);
        contactMapper.insert(contact);

        // 返回
        return contact.getId();
    }

    @Override
    public void updateContact(ContactSaveReqVO updateReqVO) {
        // 校验存在
        validateContactExists(updateReqVO.getId());
        // 更新
        ContactDO updateObj = BeanUtils.toBean(updateReqVO, ContactDO.class);
        contactMapper.updateById(updateObj);
    }

    @Override
    public void deleteContact(Long id) {
        // 校验存在
        validateContactExists(id);
        // 删除
        contactMapper.deleteById(id);
    }

    @Override
        public void deleteContactListByIds(List<Long> ids) {
        // 删除
        contactMapper.deleteByIds(ids);
        }


    private void validateContactExists(Long id) {
        if (contactMapper.selectById(id) == null) {
            throw exception(CONTACT_NOT_EXISTS);
        }
    }

    @Override
    public ContactDO getContact(Long id) {
        return contactMapper.selectById(id);
    }

    @Override
    public PageResult<ContactDO> getContactPage(ContactPageReqVO pageReqVO) {
        return contactMapper.selectPage(pageReqVO);
    }

}
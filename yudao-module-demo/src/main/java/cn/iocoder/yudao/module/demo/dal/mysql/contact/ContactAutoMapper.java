//不可修改，重复生成会覆盖
package cn.iocoder.yudao.module.demo.dal.mysql.contact;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.demo.dal.dataobject.contact.ContactDO;
import cn.iocoder.yudao.module.demo.controller.admin.contact.vo.*;

/**
 * demo联系人 AutoMapper
 *
 * @author 芋道源码
 */
//@Mapper
public interface ContactAutoMapper extends BaseMapperX<ContactDO> {

    default PageResult<ContactDO> selectPage(ContactPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ContactDO>()
                .likeIfPresent(ContactDO::getName, reqVO.getName())
                .eqIfPresent(ContactDO::getSex, reqVO.getSex())
                .eqIfPresent(ContactDO::getBirthday, reqVO.getBirthday())
                .eqIfPresent(ContactDO::getDescription, reqVO.getDescription())
                .eqIfPresent(ContactDO::getAvatar, reqVO.getAvatar())
                .betweenIfPresent(ContactDO::getCreateTime, reqVO.getCreateTime())
                .likeIfPresent(ContactDO::getExt, reqVO.getExt())
                .orderByDesc(ContactDO::getId));
    }

}
package cn.iocoder.yudao.module.demo.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode CONTACT_NOT_EXISTS = new ErrorCode(1_003_000_001, "demo联系人不存在");
}

//不可修改，重复生成会覆盖
package cn.iocoder.yudao.module.demo.controller.admin.contact.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - demo联系人分页 Request VO")
@Data
public class ContactPageReqVO extends PageParam {

    @Schema(description = "名字", example = "李四")
    private String name;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "出生年")
    private LocalDateTime birthday;

    @Schema(description = "简介", example = "你猜")
    private String description;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "扩展信息")
    private String ext;

}
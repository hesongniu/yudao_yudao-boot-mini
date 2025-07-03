//不可修改，重复生成会覆盖
package cn.iocoder.yudao.module.demo.controller.admin.contact;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.demo.controller.admin.contact.vo.*;
import cn.iocoder.yudao.module.demo.dal.dataobject.contact.ContactDO;
import cn.iocoder.yudao.module.demo.service.contact.ContactService;

//@Tag(name = "管理后台 - demo联系人")
//@RestController
//@RequestMapping("/demo/contact")
@Validated
public class ContactAutoController {

    @Resource
    private ContactService contactService;

    @PostMapping("/create")
    @Operation(summary = "创建demo联系人")
    @PreAuthorize("@ss.hasPermission('demo:contact:create')")
    public CommonResult<Long> createContact(@Valid @RequestBody ContactSaveReqVO createReqVO) {
        return success(contactService.createContact(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新demo联系人")
    @PreAuthorize("@ss.hasPermission('demo:contact:update')")
    public CommonResult<Boolean> updateContact(@Valid @RequestBody ContactSaveReqVO updateReqVO) {
        contactService.updateContact(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除demo联系人")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('demo:contact:delete')")
    public CommonResult<Boolean> deleteContact(@RequestParam("id") Long id) {
        contactService.deleteContact(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除demo联系人")
                @PreAuthorize("@ss.hasPermission('demo:contact:delete')")
    public CommonResult<Boolean> deleteContactList(@RequestParam("ids") List<Long> ids) {
        contactService.deleteContactListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得demo联系人")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('demo:contact:query')")
    public CommonResult<ContactRespVO> getContact(@RequestParam("id") Long id) {
        ContactDO contact = contactService.getContact(id);
        return success(BeanUtils.toBean(contact, ContactRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得demo联系人分页")
    @PreAuthorize("@ss.hasPermission('demo:contact:query')")
    public CommonResult<PageResult<ContactRespVO>> getContactPage(@Valid ContactPageReqVO pageReqVO) {
        PageResult<ContactDO> pageResult = contactService.getContactPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ContactRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出demo联系人 Excel")
    @PreAuthorize("@ss.hasPermission('demo:contact:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportContactExcel(@Valid ContactPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ContactDO> list = contactService.getContactPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "demo联系人.xls", "数据", ContactRespVO.class,
                        BeanUtils.toBean(list, ContactRespVO.class));
    }

}
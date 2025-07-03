package cn.iocoder.yudao.module.demo.controller.admin.contact;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;

import cn.iocoder.yudao.module.demo.service.contact.ContactService;

@Tag(name = "管理后台 - demo联系人")
@RestController
@RequestMapping("/demo/contact")
@Validated
public class ContactController extends ContactAutoController{

    @Resource
    private ContactService contactService;

    //覆盖父类方法，注释掉权限检查
    //@PreAuthorize


}
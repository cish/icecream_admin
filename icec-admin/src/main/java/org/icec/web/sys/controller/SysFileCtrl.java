package org.icec.web.sys.controller;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.icec.common.base.tips.SuccessTip;
import org.icec.common.base.tips.Tip;
import org.icec.common.web.BaseController;
import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysFile;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SysFileCtrl extends BaseController{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	private SysFileService sysFileService;
	@RequiresUser
	@PostMapping("/sys/singleUpload")
	@ResponseBody
	public Tip upload(String type,@RequestParam("file") MultipartFile multiFile,@CurrentUser SysUser user) {
		 if (multiFile.isEmpty()) {  
			 return FAIL;
		 }
		
		Long fileId= sysFileService.saveUploadFile(type, multiFile, user);
		if(fileId>0) {
				SuccessTip tip=	succ("上传成功");tip.setData(fileId);
		 return tip;
		}else {
			return FAIL;
		}
	}
	@RequiresUser
	@GetMapping("/sys/showFile/{fid}")
	@ResponseBody
	public ResponseEntity<?> showImg(@PathVariable("fid") Integer fileId) {
		SysFile sysFile=sysFileService.getFile(fileId);
		try {  
            return ResponseEntity.ok(sysFileService.readFile(sysFile.getFileUrl()));  
        } catch (Exception e) {  
            return ResponseEntity.notFound().build();  
        } 
	}
	
}

package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	// 스프링에서 파일이나 클래스 등등 리소스를 로드 할 때는 ResourceLoader 인터페이스를 이용해서 가져온다.
	private ResourceLoader resourceLoader;
	
//	@Autowired
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}

	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {

		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			
			// 1st try : img폴더를 resource로 지정하는 코드가 무엇인지 기억나지 않아 다시 본 뒤 작성함
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			file.transferTo(new File(resource.getFile(), fileName));
			
			model.addAttribute("fileName", fileName);
		}

		return "result";
	}

	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
	
}

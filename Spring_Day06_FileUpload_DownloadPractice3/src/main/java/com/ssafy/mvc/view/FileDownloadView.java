package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {

	private ResourceLoader resourceLoader;

//		@Autowired
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String fileName = (String) model.get("fileName");
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName);

		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");

		// 3rd try : 헤더 설정하는 과정에서 setHeader()에 들어갈 내용이 익숙하지 않아 코드를 참고하여 작성함
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		try (FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream();) {
			FileCopyUtils.copy(fis, os);
		}

	}

}

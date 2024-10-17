### FileUpload, Download
1. 수업에서 작성한 코드를 다시 보며 새롭게 추가된 upload, download에 관한 메소드들과 view 클래스 복습
2. resourceLoader를 사용하여 img폴더에 있는 파일들을 리소스로 접근할 수 있게 하는 코드를 다시 작성
```
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
```
3. result.jsp를 작성할 때 a 태그에서 get 요청으로 download를 보내는 것까지 생각했는데 query string을 작성하는 곳에서 헷갈렸음
```
<body>
	${fileName}
	<a href="/img/${fileName}">${fileName}</a>
	<img src="/img/${fileName}">
	
	<!-- 2nd try : href 속성을 작성할 때 query string 작성이 헷갈림 -->
	<a href="/download?fileName=${fileName}">이미지다운로드</a>
</body>
```
4. response의 setHeader 메소드를 사용할 때 처음 보는 내용들이 많아 코드를 참고해서 작성함
```
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
```
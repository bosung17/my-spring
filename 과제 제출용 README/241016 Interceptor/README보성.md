### Interceptor 친해지기
1. 수업 내용을 보며 새로 배운 interceptor와 config에 관한 java file을 다시 작성해봄
2. UserController에서 login의 POST 요청을 처리하기 위한 메소드 작성 중 정해진 id, pw가 아닌 로그인은 세션에 저장하지 않고 다시 로그인하도록 하는 것에서 막힘
```
@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		// 1st try : if문 안에 user.getId(), user.getPw()를 통해 id, pw를 가져온 뒤 비교하여 세션에 저장할지 무한 로그인이 되게 만들지 결정하는 곳에서 막힘
		if (user.getId().equals("ssafy") && user.getPw().equals("1234")) {
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello";
		}
		return "redirect:login";
	}
```
3. LoginInterceptor에서 preHandle 메소드 작성 중 로그인이 되어있는지 판단하는 법이 헷갈림
```
@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 2nd try : preHandle 메소드 작성 중 session에서 loginUser 어떻게 가져오는지 헷갈림
		if (session.getAttribute("loginUser") == null) {
			return false;
		}
		return true;
	}
```
4. WebConfig에서 @Autowired 하는 것이 바로 떠오르진 않았지만 결국 떠올라서 성공!
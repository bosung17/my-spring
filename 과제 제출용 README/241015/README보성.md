### Spring Boot 적응기
1. 수업을 다시 들으며 index.html부터 UserController까지 다시 한번 만들어 봄
2.  HelloController에서 hello를 getmapping 하다가 model 만들고 넣는 거에서 막힘 &rarr; model.addAttribute와 hello로 mapping 하는 것에 대해 알게 됨
3. pom.xml에 JSP를 위한 설정을 넣어주지 않아 hello.jsp가 실행되지 않음 &rarr; pom.xml에 의존성을 넣어주는 것을 다시 생각하게 됨
4. loginForm에 form 태그와 input 태그의 속성들이 헷갈려서 코드를 다시 봄 &rarr; jsp 태그들과 속성들을 다시 공부하게 됨
5. UserController 내의 POST 요청 login과 GET 요청 logout을 처리 할 메소드들을 완성시키지 못함 &rarr; ModelAttribute Annotation과 User dto를 다시 만들어야 하는 것, session 내의 메소드 등을 다시 알게 됨
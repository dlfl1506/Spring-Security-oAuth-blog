# 스프링부트 블로그 프로젝트 V2

### 의존성

- Sring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Security
- Spring Web
- oauth2-client


```xml
<!-- 시큐리티 태그 라이브러리 -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-taglibs</artifactId>
</dependency>

<!-- JSP 템플릿 엔진 -->
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper</artifactId>
	<version>9.0.44</version>
</dependency>

<!-- JSTL -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
</dependency>
```


### DB 설정

```sql
create user 'pos'@'%' identified by 'pos1234';
GRANT ALL PRIVILEGES ON *.* TO 'pos'@'%';
create database pos;
```

### yml 설정
```
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true
    
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/pos?serverTimezone=Asia/Seoul
    username: pos
    password: pos1234
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
    properties:
      hibernate.format_sql: true

  jackson:
    serialization:
      fail-on-empty-beans: false
      
```

## ✔ 기능 

- 로그인 화면 (로그인기능)
<img src= "https://user-images.githubusercontent.com/74044212/111997749-b08ab880-8b5e-11eb-9c39-322fb7a8ba0f.png" width="300px" height="300px" />

#### OAuth 로그인을 추가했습니다.

- 회원가입 화면 (회원가입 기능) 
<img src= "https://user-images.githubusercontent.com/74044212/111997924-e2038400-8b5e-11eb-80db-4069a92c08ed.png" width="300px" height="300px" />

#### 회원가입 버튼 누를시 디비에 insert

- 메인화면
<img src= "https://user-images.githubusercontent.com/74044212/111998107-0a8b7e00-8b5f-11eb-9022-4946385d5066.png" width="100%" height="500px" />

#### 게시글 목록 전체뿌려주기 (페이징) 

- 게시판 글쓰기
<img src= "https://user-images.githubusercontent.com/74044212/111998471-5d653580-8b5f-11eb-9728-443f3a8fd012.png" width="100%" height="500px" />

#### 글쓰기 완료 버튼 누를시 post 디비에 insert 

- 회원정보보기 
<img src= "https://user-images.githubusercontent.com/74044212/111999250-26435400-8b60-11eb-9d3a-59cadbdc674f.png" width="300px" height="300px" />

- 게시글 상세보기
<img src= "https://user-images.githubusercontent.com/74044212/111998954-db294100-8b5f-11eb-88c8-d2a6a31b2b08.png" width="100%" height="500px" />

#### 게시글 상세보기 누르면 post 정보 다뿌려주기,댓글리스트 뿌려주기
#### 게시글 수정,삭제 기능 
#### 댓글등록,삭제 기능 

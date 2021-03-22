<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/css/loginForm.css">
<title>Insert title here</title>

</head>
<body>
	<section>
		<h1>로그인 페이지</h1>
		<hr />
		<form action="/login" method="POST">
			<div>
				<input type="text" placeholder="Username" name="username">
			</div>
			<div>
				<input type="password" placeholder="Password" name="password">
			</div>
			<div>
				<button type="submit" class="btn btn-primary">로그인</button>
			</div>
		</form>

		<div>	아직 회원가입이 안되셨나요 ? <a href="/joinForm">회원가입</a> </div>
			<a href="/oauth2/authorization/google"><img src="/images/google.png"/></a> <br/>
			 <a href="/oauth2/authorization/facebook"><img src="/images/facebook.png"/></a><br/>
			 <a href="/oauth2/authorization/naver"><img src="/images/naver.png"/></a> <br/>
			 <a href="/oauth2/authorization/kakao"><img src="/images/kakao.png"/></a><br/>
	</section>


</body>
</html>
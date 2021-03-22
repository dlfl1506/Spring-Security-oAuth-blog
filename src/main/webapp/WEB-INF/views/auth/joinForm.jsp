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
<link rel="stylesheet" href="/css/joinForm.css">
<title>Insert title here</title>
</head>
<body>

	<main>
		<h1>회원가입 페이지</h1>
		<hr />
	<form action="/join" method="POST">
			<div>유저네임</div>
			<div>
					<input type=" text" placeholder="Username" name="username" /><br />
			</div>

			<div>비밀번호</div>
			<div>
				<input type="password" placeholder="비밀번호" name="password">
			</div>

			<div>이메일</div>
			<div>
	<input type="email" placeholder="Email" name="email" /><br />
			</div>

			<button class="btn btn-primary">회원가입 </button>
		</form>
		<div >
			이미 아이디가 있으신가요? <a href="/loginForm">로그인하러가기</a>
		</div>


	</main>

</body>
</html>
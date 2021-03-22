<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>

		<input type="hidden" id="id" value="${post.id }" />

		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter Title" name="title"
			id="title"	value="${post.title }">
		</div>

		<div class="form-group">
			<textarea rows="" cols="5" class="form-control" name="content" id="content">
     ${post.content }
     </textarea>
		</div>

		<button class="btn btn-primary" id="btn-update">수정완료</button>
	</form>
</div>


<script src="/js/updateForm.js">
     
    </script>

<%@ include file="../layout/footer.jsp"%>
$("#btn-delete").on("click",(e)=>{
	
	 let id = e.currentTarget.value;
	
	$.ajax({
		type:"DELETE",
		url:"/post/"+id,
		dataType:"json"
	}).done(res=>{
		if(res.statusCode === 1){
			alert("삭제성공");
			history.go(-1);
		}else{
		
		}
	});
});

$("#btn-reply-save").on("click", () => {
	let data = {
		content: $("#reply-content").val(),
		userId: $("#userId").val(),
		postId: $("#postId").val(),
	}
	$.ajax({
		method:"POST",
		url : "/reply",
		data : JSON.stringify(data),
		contentType : "application/json;charset=utf-8;",
		dataType:"json"
	})
	.done(res => {
		if(res.statusCode === 1){
			location.reload(true);
		}else{
			alert("댓글 등록 실패");
		}
	});
});

function deleteReply(id){
		$.ajax({
			type: "DELETE",
			url: "/reply/"+id,
			dataType: "json"
		}).done((res)=>{
			console.log(res);
			if(res.statusCode === 1){
				$("#reply-"+id).remove();
			}else{
				alert("삭제에 실패하였습니다.");
			}
		});
	}
     
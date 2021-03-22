 $('#content').summernote({
        tabsize: 2,
        height: 300
      });    
      
   
     $("#btn-update").on("click", (e)=> {
		e.preventDefault();
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		let id = $("#id").val();

		$.ajax({
			type: "PUT",
			url: "/post/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done((res)=>{
			console.log(res);
			if(res.statusCode === 1){
				alert("수정에 성공하였습니다.");
				history.go(-1);
			}else{
				alert("수정에 실패하였습니다.");
			}
		});

	});
      
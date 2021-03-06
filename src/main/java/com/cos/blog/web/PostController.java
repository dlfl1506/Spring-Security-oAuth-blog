package com.cos.blog.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.PostService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.post.dto.PostSaveReqDto;
import com.cos.blog.web.post.dto.PostUpdateReqDto;
import com.cos.blog.web.user.dto.UserUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PostController {

	private final PostService postService;

//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}

	
		@GetMapping("/search")
		public String search(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size=3)Pageable pageable,String value) {
			Page<Post> posts= postService.검색(pageable,value);
			 model.addAttribute("posts",posts);
			return "post/list";
		}
	
	
	   @GetMapping("/") //메인페이지
	   public String findAll(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size=3) Pageable pageable,
			   @AuthenticationPrincipal PrincipalDetails principalDetails) { // id로 정렬, 내림차순, 3개씩,  Pageable 도메인꺼임
	   
		   Page<Post> posts = postService.전체찾기(pageable);
	      model.addAttribute("posts",posts); // 모델을 제공해줘서 모델에 담으면 된다. 그러면 값을 담고 리스트 페이지로 간다.//모델에 JSP 에서 리퀘스트디스패쳐에 담고 forward한거랑 같다 
	      return "post/list";
	   }

	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}
	
	@GetMapping("/post/{id}/updateForm")
	public String updateForm(@PathVariable int id,Model model) {
		Post postEntity = postService.상세보기(id);
		model.addAttribute("post",postEntity);
		return "post/updateForm";
	}

	  @PutMapping("/post/{id}")
		public @ResponseBody CMRespDto<?> update(@PathVariable int id, @RequestBody PostUpdateReqDto postUpdateReqDto) {
	        postService.글수정(id,postUpdateReqDto);	
			return new CMRespDto<>(1,null);
		}
	  
	@GetMapping("/post/{id}")
	public String detail(@PathVariable int id ,Model model) {
		Post postEntitiy =postService.상세보기(id);
		model.addAttribute("post",postEntitiy);
		return "post/detail"; // ViewResolver
	}

	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id){
		postService.삭제하기(id);
		return new CMRespDto<>(1,null);
	}
	

	@PostMapping("/post")
	public String save(PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Post post = postSaveReqDto.toEntity();
		post.setUser(principalDetails.getUser());
		Post postEntity = postService.글쓰기(post);
		
		if(postEntity == null) {
			return "post/saveForm";
		}else {
			return "redirect:/";
		}
	}
}

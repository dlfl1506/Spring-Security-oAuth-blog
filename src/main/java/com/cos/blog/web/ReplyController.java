package com.cos.blog.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.reply.ReplyRepository;
import com.cos.blog.service.ReplyService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.reply.dto.ReplySaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyController {

	private final ReplyService replyService;


	@PostMapping("/reply")
	public CMRespDto<?> save(@RequestBody ReplySaveReqDto replySaveReqDto){
		Reply replyEntity = replyService.댓글등록(replySaveReqDto.toEntity());
		if(replyEntity == null){
			return new CMRespDto<>(-1, null);	
		}else {
			return new CMRespDto<>(1, replyEntity);	
		}
	}
	
	
	@DeleteMapping("/reply/{id}")
	public CMRespDto<?> deleteById(@PathVariable int id,@AuthenticationPrincipal PrincipalDetails principalDetails){
		// 모든 컨트롤러에 삭제하기 , 수정하기는 무조건 동일인물이 로그인했는지 확인!!
		int result = replyService.삭제하기(id,principalDetails.getUser().getId());
		
		return new CMRespDto<>(result,null);
	}
	
		
	
}

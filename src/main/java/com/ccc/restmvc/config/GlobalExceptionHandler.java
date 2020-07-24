package com.ccc.restmvc.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ccc.restmvc.entity.ParamValidMsg;
import com.ccc.restmvc.entity.ResponseEntity;
import com.ccc.restmvc.entity.enumvalue.StatusCode;

/**
 * 捕捉参数抛出异常
 * 
 * @author ccc
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * TODO post 参数校验
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ParamValidMsg>> checkRequest(MethodArgumentNotValidException e) {

		BindingResult bindingResult = e.getBindingResult();

		return ResponseEntity.error(
				bindingResult
					.getFieldErrors()
						.stream()
							.map(fieldError -> new ParamValidMsg(fieldError.getField(), fieldError.getDefaultMessage()))
							.collect(Collectors.toList()), 
				StatusCode.PARAM_ERROR);
	}
	
	/**
	 * TODO 检测requestparam的参数错误
	 * @param e
	 * @return
	 */
	@ExceptionHandler({
		MissingServletRequestParameterException.class,//缺少参数
		MethodArgumentTypeMismatchException.class//类型错误
	})
	public ResponseEntity<String> pathCheck(Exception e){
		return ResponseEntity.error(
				e.getMessage(), 
				StatusCode.PARAM_ERROR
		);
	}

}

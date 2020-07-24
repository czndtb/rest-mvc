package com.ccc.restmvc.entity;

import com.ccc.restmvc.entity.enumvalue.StatusCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseEntity<T> {
	private int code;
	private String msg;
	private T data;

	public static <T> ResponseEntity<T> okEmptyMsg() {

		return ok(null, StatusCode.OK);

	}

	public static <T> ResponseEntity<T> ok(T data) {

		return ok(data, StatusCode.OK);

	}

	public static <T> ResponseEntity<T> ok(T data, StatusCode statusCode) {

		return make(data, statusCode.getCode(), statusCode.getMsg());

	}

	public static <T> ResponseEntity<T> error(T data, StatusCode statusCode) {

		return make(data, statusCode.getCode(), statusCode.getMsg());

	}

	/**
	 * TODO 最基础的写法，所有封装对象转为基本类型
	 * 
	 * @param <T>
	 * @param data
	 * @param code
	 * @param msg
	 * @return
	 */
	private static <T> ResponseEntity<T> make(T data, int code, String msg) {

		return ResponseEntity.<T>builder().code(code).msg(msg).data(data).build();

	}

}

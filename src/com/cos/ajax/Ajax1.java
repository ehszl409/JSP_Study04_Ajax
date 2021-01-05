package com.cos.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ajax1")
public class Ajax1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ajax1() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받은 JSON데이터를 읽고 자바 오브젝트로 변경해서 콘솔에 뿌리기.
		BufferedReader br = request.getReader(); // 요청을 버퍼로 읽기
		String requestData = br.readLine();
		System.out.println("requestData: " + requestData);
		
		Gson gson = new Gson();
		// gson.fromJson() => json을 자바 오브젝트로
		// gson.toJson() => 자바 오브젝트를 json으로
		UserDto userDto = gson.fromJson(requestData, UserDto.class);
		System.out.println("userDto: " + userDto);
		
		
		// 자바 오브젝트를 JSON으로 변경 후 응답해 주기.
		User user = new User();
		user.setId(1);
		user.setUsername("park");
		user.setPassword("5678");
		user.setPhone("301212");
		
		String userJson = gson.toJson(user);
		response.setContentType("json");
		PrintWriter out = response.getWriter();
		out.print(userJson);
		out.flush();
		
	}

}

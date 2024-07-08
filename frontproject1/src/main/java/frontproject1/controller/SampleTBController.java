package frontproject1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontproject1.dao.SampleTBDAO;
import frontproject1.vo.SampleTBVO;

public class SampleTBController {
	
	public void getAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//frontcontroller에서 sampleTB관련 모든 요청을 받아서
		//각 목적애 맞는 메소드를 분기하는 영역
		
		if(uris[1].equals("list.do")) {
			list(request,response);
		}else if(uris[1].equals("modify.do")) {
			modify(request,response);
		}else if(uris[1].equals("view.do")) {
			view(request,response);
		}else if(uris[1].equals("insert.do")) {
			insert(request,response);
		}
		
	}
	
	public void postAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//post 요청에 대한 처리
		if(uris[1].equals("modify.do")){
			modifyOk(request, response);
		}else if(uris[1].equals("insert.do")) {
			insertOk(request,response);
		}
	}
	
	
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		List<SampleTBVO> slist = sampleTBDao.select();
		request.setAttribute("slist", slist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/list.jsp");
		rd.forward(request, response);
		
		System.out.println("list.do 실행!");
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sviewParam = request.getParameter("sno"); 
		
		int sno = 0;
		
		if(sviewParam != null && !sviewParam.equals("")) {
			 sno = Integer.parseInt(sviewParam);
		}else{
			response.sendRedirect("list.do");
		}
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		SampleTBVO sview = sampleTBDao.selectOne(sno);
		
		request.setAttribute("sview", sview);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modify.jsp");
		rd.forward(request, response);
		
		System.out.println("modify.do 실행!");
		
	}
	
	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sviewParam = request.getParameter("sno"); 
		
		int sno = 0;
		
		if(sviewParam != null && !sviewParam.equals("")) {
			 sno = Integer.parseInt(sviewParam);
		}else{
			response.sendRedirect("list.do");
		}
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		SampleTBVO sview = sampleTBDao.selectOne(sno);
		
		request.setAttribute("sview", sview);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/view.jsp");
		rd.forward(request, response);
		
		System.out.println("view.do 실행!");
		
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/insert.jsp");
			rd.forward(request, response);
			System.out.println("insert.do 실행!");
	}
	
	
	private void modifyOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String sviewParam = request.getParameter("sno"); 
		
		int sno = 0;
		
		if(sviewParam != null && !sviewParam.equals("")) {
			 sno = Integer.parseInt(sviewParam);
		}
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");

		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		int result = sampleTBDao.update(sno, title, writer, body);
		
		if(result > 0) {
			response.sendRedirect("view.do?sno=" + sno);
		}else {
			//수정 실패
			response.sendRedirect("modify.do?sno=" +sno+ "&msg=fail");
		}
	}
	
		private void insertOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			SampleTBVO svo = new SampleTBVO();

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String body = request.getParameter("body");

			
			SampleTBDAO sampleTBDao = new SampleTBDAO();
			int result = sampleTBDao.insert(title, writer, body);
			
			if(result > 0) {
				response.sendRedirect("list.do?sno=" + svo);
			}else {
				//수정 실패
				response.sendRedirect("insert.do?sno=" + svo + "&msg=fail");
			}
	}
	
	
	
}

package frontproject1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * frontcontroller는 모든 가상 경로를 제일 먼저 받아
 * 
 * */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURI();  //전체 url(도메인 제외)
		String contextPath = request.getContextPath();  //프로젝트 path
		
		String command = requestURL.substring(contextPath.length()+1);//프로젝트 path를 제외한 uri
		
		String[] uris = command.split("/");
		if(uris[0].equals("sampleTB")) {
			
			SampleTBController sampleTBController = new SampleTBController();
			
			
			sampleTBController.getAction(request,response,uris);
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String requestURL = request.getRequestURI();  //전체 url(도메인 제외)
		String contextPath = request.getContextPath();  //프로젝트 path
		
		String command = requestURL.substring(contextPath.length()+1);//프로젝트 path를 제외한 uri
		
		String[] uris = command.split("/");
		if(uris[0].equals("sampleTB")) {
			
			SampleTBController sampleTBController = new SampleTBController();
			

			sampleTBController.postAction(request,response,uris);
			
		}
	
	}

}

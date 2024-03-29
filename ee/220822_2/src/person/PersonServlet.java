package person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.InputBuffer;

@WebServlet("/api/person")
public class PersonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "application/json; charset=utf-8");
		PrintWriter out = resp.getWriter(); //body에 값 써넣기위해 resp에서 out객체 가져오기
		out.print("{}"); //여기에 원하는 정보를 넣어주면됨! ex)다오객체 만들어서 db정보넣기
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mime = req.getHeader("content-type");
		if (!mime.equals("application/json")) {
			resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

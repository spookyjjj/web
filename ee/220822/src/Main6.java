import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main6 {
	public static void main(String[] args) {
		String apiURL = "http://httpbin.org/post";
		
		//OkHttp로 api사용해보기~
		//=============post방식
		OkHttpClient client = new OkHttpClient();
		RequestBody reqBody = RequestBody.create("일반텍스트", MediaType.get("text/plain; charset=utf-8"));
		//post에서는 RequestBody부분만 추가해서 진행하면 됨~
		Request req = new Request.Builder().url(apiURL).post(reqBody).build();

		try (Response resp = client.newCall(req).execute()) {
			if (resp.code() == 200) {
				System.out.println(resp.body().string());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

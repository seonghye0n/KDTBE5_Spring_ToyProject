import java.util.Set;

import util.ComponentScan;
import util.MethodInfo;
import util.MyScanner;

public class BaseBallApp {

	//@TODO: 별도 App 클래스 만들어서 메인 메서드에서는 App.run(); 방식으로 구조 변경
	public static void main(String[] args) throws Exception {

		MyScanner scanner = new MyScanner();
		ComponentScan componentScan = ComponentScan.getInstance();

		while (true) {
			String uri = scanner.getRequest();
			if (uri.equals("종료"))
				break;
			
			MethodInfo methodInfo = scanner.parseData(uri);
			Set<Class> classes = componentScan.scanPackage("controller");
			String response = componentScan.findUri(classes, methodInfo);

			System.out.println(response);
		}

	}
}
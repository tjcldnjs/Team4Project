package RentCar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCarConnectionManager {
	
	private static final String URL = "jdbc:mysql://192.168.0.140:3306/greencar?serverTimezone=Asia/Seoul";
	private static final String USER = "tenco4";
	private static final String PASSWORD = "1q2w3e4r5t!";

	// static {} 블록 - 정적 초기화 블록
	// 클래스가 처음 로드 될 떄 한번 실행 됩니다.
	// 정적 변수의 초기화나 복잡한 초기화 작업을 수행 할 떄 사용
	// static {} 안에 예외를 던질 수도 있다.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 정적 메서드(함수) 커넥션 객체를 리턴하는 함수를 만들어 보자
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	

}

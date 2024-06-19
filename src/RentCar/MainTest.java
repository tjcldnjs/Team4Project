package RentCar;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import RentCar.carmodel.selectDTO;

public class MainTest {

	public static void main(String[] args) {
		CarDAO dao = new CarDAO();

		try (Connection conn = DBCarConnectionManager.getConnection(); Scanner sc = new Scanner(System.in)) {

			List<selectDTO> list = dao.orderAscPriceType();
			for (selectDTO selectDTO : list) {
				System.out.println(selectDTO);
			}

			System.out.println("==================");

			List<selectDTO> list1 = dao.orderDescPriceType();
			for (selectDTO selectDTO : list1) {
				System.out.println(selectDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

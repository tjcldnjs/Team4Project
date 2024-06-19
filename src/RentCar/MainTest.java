package RentCar;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import RentCar.carmodel.CarInfoDTO;
import RentCar.carmodel.ReservationDTO;
import RentCar.carmodel.selectDTO;

public class MainTest {

	public static void main(String[] args) {
		CarDAO dao = new CarDAO();

		try (Connection conn = DBCarConnectionManager.getConnection(); 
				Scanner sc = new Scanner(System.in)) {
			while (true) {
				Menu();
				int menuchoice = sc.nextInt();
				if (menuchoice == 1) {
					// 차량으로 예약하기
					ReservationByCarMenu();
					int ReservationByCarMenuchoice = sc.nextInt();
					if (ReservationByCarMenuchoice == 1) {
						System.out.println("== 브랜드 필터 ==");
						System.out.println("1. 기아  2. 현대  3. 테슬라");
						String brand = null;
						int brandchoice = sc.nextInt();
						if (brandchoice == 1) {
							brand = "기아";
						} else if (brandchoice == 2) {
							brand = "현대";
						} else if (brandchoice == 3) {
							brand = "테슬라";
						}
						List<selectDTO> list = dao.viewBrandType(brand);
						for (selectDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					} else if (ReservationByCarMenuchoice == 2) {
						System.out.println("== 차종 필터 ==");
						System.out.println("1. 준중형  2. 중형  3. 대형");
						String cartype = null;
						int cartypechoice = sc.nextInt();
						if (cartypechoice == 1) {
							cartype = "준중형";
						} else if (cartypechoice == 2) {
							cartype = "중형";
						} else if (cartypechoice == 3) {
							cartype = "소형";
						}
						// 호출 /////////////////////////////////
					} else if (ReservationByCarMenuchoice == 3) {
						System.out.println("== 유종 필터 ==");
						System.out.println("1. 전기  2. 수소  3. 가스  4. 디젤  5. 가솔린");
						String puel = null;
						int puelchoice = sc.nextInt();
						if (puelchoice == 1) {
							puel = "전기";
						} else if (puelchoice == 2) {
							puel = "수소";
						} else if (puelchoice == 2) {
							puel = "가스";
						} else if (puelchoice == 2) {
							puel = "디젤";
						} else if (puelchoice == 2) {
							puel = "가솔린";
						}
						List<CarInfoDTO> list = dao.selecPuel(puel);
						for (CarInfoDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					} else if (ReservationByCarMenuchoice == 4) {
						System.out.println("== 가격순 필터 ==");
						System.out.println("1. 낮은 가격부터  2. 높은 가격부터");
						int orderchoice = sc.nextInt();
						if (orderchoice == 1) {
							dao.orderAscPriceType();
						} else if (orderchoice == 2) {
							dao.orderDescPriceType();
						}
					} else if (ReservationByCarMenuchoice == 5) {
						System.out.println("== 면허 필터 ==");
						System.out.println("1. 1종  2. 2종");
						String needLicence = null;
						int needLicencechoice = sc.nextInt();
						if (needLicencechoice == 1) {
							needLicence = "1종";
						} else if (needLicencechoice == 2) {
							needLicence = "2종";
						}
						List<selectDTO> list = dao.viewneedLicenceType(needLicence);
						for (selectDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					}
				} else if (menuchoice == 2) {
					// 날짜로 예약하기
					// 추가
				} else if (menuchoice == 3) {
					// 예약조회 및 변경하기
					ViewandUpdateMenu();
					int viewUpdatechoice = sc.nextInt();
					if (viewUpdatechoice == 1) {
						System.out.println("== 이름으로 조회하기 ==");
						String name = sc.nextLine();
						List<ReservationDTO> list = dao.reservationNameSelec(name);
						for (ReservationDTO reservationDTO : list) {
							System.out.println(reservationDTO);
						}
					} else if (viewUpdatechoice == 2) {
						System.out.println("== 예약번호로 조회하기 ==");
						int id = sc.nextInt();
						ReservationDTO dto = dao.reservationNumSelec(id);
						System.out.println(dto.toString());
					} else if (viewUpdatechoice == 3) {
						System.out.println("== 예약 변경하기 ==");
						// 추가
					}

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void Menu() {
		System.out.println("1. 차량으로 예약하기");
		System.out.println("2. 날짜로 예약하기");
		System.out.println("3. 예약조회 및 변경하기");
	}

	private static void ReservationByCarMenu() {
		System.out.println("== 차량으로 예약하기 ==");
		System.out.println("1. 브랜드 필터");
		System.out.println("2. 차종 필터");
		System.out.println("3. 유종필터");
		System.out.println("4. 가격순 필터");
		System.out.println("5. 면허 필터");
	}

	private static void ViewandUpdateMenu() {
		System.out.println("== 예약조회 및 변경하기 ==");
		System.out.println("1. 이름으로 조회하기");
		System.out.println("2. 예약번호로 조회하기");
		System.out.println("3. 예약 변경하기");
	}
}

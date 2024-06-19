package RentCar;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import RentCar.carmodel.CarInfoDTO;
import RentCar.carmodel.ReservationDTO;
import RentCar.carmodel.selectDTO;

public class MainTestCar {

	public static void main(String[] args) {
		CarDAO dao = new CarDAO();

		try (Connection conn = DBCarConnectionManager.getConnection(); 
				Scanner sc = new Scanner(System.in)) {
			while (true) {
				menu();
				int chioce = sc.nextInt();
				try {
					if (chioce == 1) {
						System.out.println("나열한 기준을 선택하시오");
						System.out.println("1. 차량 회사별, 2. 유종별, 3. 가격별 4. 차종별 5.면허별");
						
						int chioce1 = sc.nextInt();
						if (chioce1 == 1) {
							// 차량회사별 보기
							// 1. 기아 2. 테슬라 , 3.현대

						} else if (chioce1 == 2) {
							// 유종별 보기
							System.out.println("유종별 보기");
							System.out.println("유종별 을 고르시오");
							System.out.println("1.전기 2.수소 3.가스 4.디젤 5.가솔린");
							int chiocePuel = sc.nextInt();
							String puel = null;
							if(chiocePuel == 1) {
								// 전기
								puel = "전기";
							} else if(chiocePuel == 2) {
								//수소
								puel = "수소";
							} else if(chiocePuel == 3) {
								// 가스
								puel = "가스";
							} else if(chiocePuel == 4) {
								// 디젤
								puel = "디젤";
							} else if(chiocePuel == 5) {
								// 가솔린
								puel = "가솔린";
							} else {
								System.out.println("잘못입력함");
							}
							List<CarInfoDTO> list = dao.selecPuel(puel);
							for (CarInfoDTO carInfoDTO : list) {
								System.out.println(carInfoDTO);
							}

						} else if (chioce1 == 3) {
							// 가격별
							System.out.println("가격별 보기");
							System.out.println("1. 낮은 가격순, 2. 높은가격순");
							int chiocePrice = sc.nextInt();
							String price = null;
							if(chiocePrice == 1 ) {
								price = "ase";
							} else if (chiocePrice == 2) {
								price = "dese";
							} else {
								System.out.println("잘못 입력합");
							}
//							List<selectDTO> list = dao.orderPrice(price);
//							for (selectDTO selectDTO : list) {
//								System.out.println(selectDTO);
//							}

						} else {
							System.out.println("잘못입력함");
						}

					} else if (chioce == 2) {

						// 날자별

					} else if (chioce == 3) {
						System.out.println("1. 이름 으로 찾기 , 2. 예약번호로 찾기");
						int chioce3 = sc.nextInt();
						if (chioce3 == 1) {
							System.out.println("이름으로 예약 찾기");
							sc.nextLine();
							String name = sc.nextLine();
							List<ReservationDTO> list = dao.reservationNameSelec(name);
							for (ReservationDTO reservationDTO : list) {
								System.out.println(reservationDTO);

							}
						} else if (chioce3 == 2) {
							System.out.println("예약번호로 예약 찾기");
							int id = sc.nextInt();
							ReservationDTO dto = dao.reservationNumSelec(id);
							System.out.println(dto.toString());

						} else {
							System.out.println("다시");
						}
					} else {
						System.out.println("다시");
					}

				} catch (Exception e) {
					System.out.println("숫자 입력해라 숫자2");
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			System.out.println("숫자 입력해라 숫자");
			e.printStackTrace();
		}

	} // end of main

	private static void menu() {
		System.out.println("1. 차량으로 예약");
		System.out.println("2. 날자로 예약");
		System.out.println("3. 예약 조회");
	}

}

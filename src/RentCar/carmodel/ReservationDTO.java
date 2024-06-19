package RentCar.carmodel;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDTO {
	// 수정ㅇ
	private int id;
	private String name; // 예약자
	private String carname; // 차량명
	private String cartype; // 기종
	private String brand;
	private String puel; // 유종
	private String Phonenum;
	private Date rentdate; // 렌트일
	private Date returndate; // 반납일
	private int totalprice; // 가격 
	private int paymentornot; // 결제여부

}

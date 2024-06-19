package RentCar.carmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CarInfoDTO {
	
	private String carname;
	private String carid;
	private String cartype;
	private String brand;
	private String puel;
	private String needlicence;
	private int priceperday;
}

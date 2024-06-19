package RentCar.carmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationPersonInfoDTO {
	
	private String name;
	private int license_num;
	private String license_greade;
	private String phone_num;
	
}

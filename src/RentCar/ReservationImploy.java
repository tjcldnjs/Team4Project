package RentCar;

import java.sql.SQLException;
import java.util.List;

import RentCar.carmodel.CarInfoDTO;
import RentCar.carmodel.ReservationDTO;
import RentCar.carmodel.ReservationPersonInfoDTO;
import RentCar.carmodel.selectDTO;

public interface ReservationImploy {

	// 예약 번호로 조회하는 쿼리
	public ReservationDTO reservationNumSelec(int id) throws SQLException;
	// 예약자 이름으로 조회하는 쿼리
	public List<ReservationDTO> reservationNameSelec(String name) throws SQLException;
	// 차량을 유종별로 정렬해서 조회하는 쿼리
	public List<CarInfoDTO> selecPuel(String puel) throws SQLException;
	// 차종 별로 정렬 해서 조회하는 쿼리
	public List<selectDTO> orderCartype() throws SQLException;
	// 차량을 이름으로 조회
	public List<selectDTO> viewNameType(String name) throws SQLException;
	// 차량을 브랜드로 조회
	public List<selectDTO> viewBrandType(String brand) throws SQLException;
	// 차량을 요구면허로 조회하는 쿼리
	public List<selectDTO> viewneedLicenceType(String needlicence) throws SQLException;
	// 차량을 1일당 가격 순으로 오름차순 정렬하는 쿼리(최저가 정렬)
	public List<selectDTO> orderAscPriceType() throws SQLException;
	// 차량을 1일당 가격 순으로 오름차순 정렬하는 쿼리(최고가 정렬)
	public List<selectDTO> orderDescPriceType() throws SQLException;
	
}

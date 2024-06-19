package RentCar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import RentCar.carmodel.CarInfoDTO;
import RentCar.carmodel.ReservationDTO;
import RentCar.carmodel.selectDTO;

public class CarDAO implements ReservationImploy {
	@Override
	public ReservationDTO reservationNumSelec(int id) throws SQLException {

		ReservationDTO reservationDTO = null;

		String query = " SELECT ri.id, ri.name, cm.carname, ci.cartype, ci.brand, ci.puel , rp.PhoneNum, re.rentDate, re.returnDate, datediff(re.returnDate,re.rentDate)*ci.priceperday as totalprice, ri.pay as paymentOrNot from reservationInfo as ri join reservationPersonInfo as rp on ri.name = rp.name join recruittable as re on re.id = ri.id join carmanagement as cm on cm.carid = re.carid join carinfo as ci on ci.carname = cm.carname where ri.id = ?; ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel = rs.getString("puel");
				String Phonenum = rs.getString("Phonenum");
				Date rentdate = rs.getDate("rentdate");
				Date returndate = rs.getDate("returndate");
				int totalprice = rs.getInt("totalprice");
				int paymentornot = rs.getInt("paymentornot");

				reservationDTO = new ReservationDTO(id1, name, carname, cartype, brand, puel, Phonenum, rentdate,
						returndate, totalprice, paymentornot);
				System.out.println(reservationDTO.getCarname());
			}

		}
		return reservationDTO;
	}

	@Override
	public List<ReservationDTO> reservationNameSelec(String name) throws SQLException {
		List<ReservationDTO> list = new ArrayList<>();
		String query = " SELECT ri.id, ri.name, cm.carname, ci.cartype, ci.brand, ci.puel , rp.Phonenum, re.rentdate, re.returndate, day(re.rentdate - re.returndate)*ci.priceperday as totalprice, ri.pay as paymentornot from reservationinfo as ri join reservationpersoninfo as rp on ri.name = rp.name join recruittable as re on re.id = ri.id join carmanagement as cm on cm.carid = re.carid join carinfo as ci on ci.carname = cm.carname where ri.name = ?  ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name1 = rs.getString("name");
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel = rs.getString("puel");
				String Phonenum = rs.getString("Phonenum");
				Date rentdate = rs.getDate("rentdate");
				Date returndate = rs.getDate("returndate");
				int totalprice = rs.getInt("totalprice");
				int paymentornot = rs.getInt("paymentornot");
				list.add(new ReservationDTO(id, name1, carname, cartype, brand, puel, Phonenum, rentdate, returndate,
						totalprice, paymentornot));
			}

		}
		return list;
	}

	@Override
	public List<CarInfoDTO> selecPuel(String puel) throws SQLException {
		List<CarInfoDTO> list = new ArrayList<>();

		String query = " select cm.carname, cm.carid, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.puel = ?; ";

		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, puel);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String carname = rs.getString("carname");
				String carid = rs.getString("carid");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				CarInfoDTO dto = new CarInfoDTO(carname, carid, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}

		return list;
	}

	@Override
	public List<selectDTO> orderCartype() throws SQLException {
		List<selectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname order by ci.cartype asc; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				selectDTO dto = new selectDTO(carname, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public List<selectDTO> viewBrandType(String brand) throws SQLException {
		List<selectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.brand = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, brand);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand1 = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				selectDTO dto = new selectDTO(carname, cartype, brand1, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public List<selectDTO> viewNameType(String name) throws SQLException {
		List<selectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where cm.carname = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand1 = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				selectDTO dto = new selectDTO(carname, cartype, brand1, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public List<selectDTO> viewneedLicenceType(String needlicence) throws SQLException {
		List<selectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname where ci.needlicence = ?; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, needlicence);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand1 = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence1 = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				selectDTO dto = new selectDTO(carname, cartype, brand1, puel1, needlicence1, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public List<selectDTO> orderAscPriceType() throws SQLException {
		List<selectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname order by ci.priceperday; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				selectDTO dto = new selectDTO(carname, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public List<selectDTO> orderDescPriceType() throws SQLException {
		List<selectDTO> list = new ArrayList<>();

		String query = " select cm.carname, ci.cartype, ci.brand, ci.puel, ci.needlicence, ci.priceperday from carmanagement as cm join carinfo as ci on cm.carname = ci.carname order by ci.priceperday desc; ";
		try (Connection conn = DBCarConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String carname = rs.getString("carname");
				String cartype = rs.getString("cartype");
				String brand = rs.getString("brand");
				String puel1 = rs.getString("puel");
				String needlicence = rs.getString("needlicence");
				int priceperday = rs.getInt("priceperday");
				selectDTO dto = new selectDTO(carname, cartype, brand, puel1, needlicence, priceperday);
				list.add(dto);
			}
		}
		return list;
	}

}

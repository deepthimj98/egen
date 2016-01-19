package io.mmrestaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.mmrestaurant.exception.AppException;

import io.mmrestaurant.model.Guest_reservation;
import io.mmrestaurant.util.DBUtil;


public class GuestReservationDAO {

	public List<Guest_reservation> viewAllReservation()throws AppException  {
		List<Guest_reservation> guest = new ArrayList<Guest_reservation>();
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM restaurant_db.guest_reservation");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Guest_reservation guest1 = new Guest_reservation();
				guest1.setId(rs.getInt("id"));
				guest1.setReserve_date(rs.getString("reserve_date"));
				guest1.setReserve_time(rs.getString("reserve_time"));
				guest1.setNo_guests(rs.getInt("no_guests"));
				guest1.setGuest_name(rs.getString("guest_name"));
				guest1.setGuest_email(rs.getString("guest_email"));
				guest1.setGuest_phone(rs.getString("guest_phone"));
				guest1.setCcode(rs.getString("ccode"));
				guest1.setReserve_status(rs.getString("resreve_status"));
				
				
				guest.add(guest1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally {
			
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}

				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return guest;
	}

	public Guest_reservation viewReservationByCcode(String ccode)throws AppException {
		
	
			
			Connection con = DBUtil.connect();
			Guest_reservation guest2=null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = con.prepareStatement("SELECT * FROM restaurant_db.guest_reservation WHERE ccode =?");
				ps.setString(1, ccode);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					guest2 = new Guest_reservation();		
					guest2.setId(rs.getInt("id"));
					guest2.setReserve_date(rs.getString("reserve_date"));
					guest2.setReserve_time(rs.getString("reserve_time"));
					guest2.setNo_guests(rs.getInt("no_guests"));
					guest2.setGuest_name(rs.getString("guest_name"));
					guest2.setGuest_email(rs.getString("guest_email"));
					guest2.setGuest_phone(rs.getString("guest_phone"));
					guest2.setCcode(rs.getString("ccode"));
					guest2.setReserve_status(rs.getString("resreve_status"));
					
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				
				try {
					if (ps != null) {
						ps.close();
					}

					if (rs != null) {
						rs.close();
					}

					if (con != null) {
						con.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return guest2;
		
	
	}


	public Guest_reservation createNewReservation(Guest_reservation guest3)throws AppException {
		// TODO Auto-generated method stub
			Connection con = DBUtil.connect();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = con.prepareStatement("INSERT INTO guest_reservation (reserve_date, reserve_time, no_guests, guest_name, guest_email, guest_phone, ccode, resreve_status) VALUES (?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, guest3.getReserve_date());
				ps.setString(2, guest3.getReserve_time());
				ps.setInt(3, guest3.getNo_guests());
				ps.setString(4, guest3.getGuest_name());
				ps.setString(5, guest3.getGuest_email());
				ps.setString(6, guest3.getGuest_phone());
				ps.setString(7, guest3.getCcode());
				ps.setString(8, guest3.getReserve_status());
				
				
				ps.executeUpdate();
				
				rs = ps.getGeneratedKeys();
				
				if(rs.next()) {
					guest3.setId(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
			finally {
				
				try {
					if (ps != null) {
						ps.close();
					}

					if (rs != null) {
						rs.close();
					}

					if (con != null) {
						con.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return guest3;
				
	}

	public Guest_reservation updateReservation(String ccode, Guest_reservation guest4) throws AppException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("UPDATE guest_reservation SET reserve_date=?, reserve_time=?, no_guests=?, guest_name=?, guest_email=?, guest_phone=?, resreve_status=? WHERE ccode=?");
			ps.setString(1, guest4.getReserve_date());
			ps.setString(2, guest4.getReserve_time());
			ps.setInt(3, guest4.getNo_guests());
			ps.setString(4, guest4.getGuest_name());
			ps.setString(5, guest4.getGuest_email());
			ps.setString(6, guest4.getGuest_phone());
			ps.setString(7, guest4.getReserve_status());
			ps.setString(8, ccode);
		
			
			
			ps.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally {
			
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}

				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return guest4;
			

	}

	

	public void deleteByCode(String ccode) throws AppException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("DELETE FROM guest_reservation WHERE ccode=?");
			ps.setString(1, ccode);
			
		
			
			
			ps.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally {
			
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}

				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
			

	}
		
	}




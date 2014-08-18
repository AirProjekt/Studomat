package hr.web.aplikacije.domain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseUtils {
	private static Connection connectToDatabase() throws SQLException,
			IOException, NamingException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx
				.lookup("jdbc/StudomatDB");
		return dataSource.getConnection();
	}

	private static void closeConnectionToDatabase(final Connection p_connection)
			throws SQLException {
		p_connection.close();
	}

	public static List<Kolegij> fetchAllKolegijList() throws
	SQLException, NamingException, IOException {
		Connection conn = connectToDatabase();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT KOLEGIJ_ID ID, NAZIV NAZIV_KOLEGIJA,ECTS,VRSTA_KOLEGIJA FROM STUDOMAT.KOLEGIJ");
		
		List<Kolegij> kolegijList = new ArrayList<>();
		
		while (rs.next()) {
			Kolegij kolegij = new Kolegij();
			kolegij.setId(rs.getInt("ID"));
			kolegij.setNazivKolegija(rs.getString("NAZIV_KOLEGIJA"));
			kolegij.setEcts(rs.getInt("ECTS"));
			if (Kolegij.VRSTA_KOLEGIJA_OBVEZNI_ID == rs.getInt("VRSTA_KOLEGIJA")) {
				kolegij.setVrstaKolegija(VrstaKolegija.OBVEZNI);
			}
			else{
				kolegij.setVrstaKolegija(VrstaKolegija.IZBORNI);
			}
			kolegijList.add(kolegij);
		}
		
		closeConnectionToDatabase(conn);
		return kolegijList;
	}
	
	public static void insertKolegijResults(Integer korisnikId, Integer kolegijId)throws SQLException, NamingException, IOException{
		Connection conn = connectToDatabase();
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO STUDOMAT.UPIS (KORISNIK_ID,KOLEGIJ_ID)"
				+"VALUES (?,?)");
		
		stmt.setInt(1, korisnikId);
		stmt.setInt(2, kolegijId);
		stmt.executeUpdate();
		
		closeConnectionToDatabase(conn);
	}
	
	public static Integer retriveKorisnikId(String userName)throws SQLException, NamingException, IOException{
		Connection conn = connectToDatabase();
		
		PreparedStatement stmtKorisnik = conn.prepareStatement("SELECT KORISNIK_ID FROM STUDOMAT.KORISNIK WHERE KORISNICKO_IME = ?");
		stmtKorisnik.setString(1, userName);
		
		ResultSet rs = stmtKorisnik.executeQuery();
		rs.next();
		Integer id = rs.getInt("KORISNIK_ID");
		
		closeConnectionToDatabase(conn);
		
		return id;
	}
	
	public static List<Kolegij> fetchAllKolegijListUpisani(Integer id) throws
	SQLException, NamingException, IOException {
		Connection conn = connectToDatabase();
		
		PreparedStatement stmt = conn.prepareStatement("SELECT k.KOLEGIJ_ID ID, NAZIV NAZIV_KOLEGIJA,ECTS,VRSTA_KOLEGIJA FROM STUDOMAT.KOLEGIJ k "
				+ "LEFT JOIN STUDOMAT.UPIS u ON k.KOLEGIJ_ID = u.KOLEGIJ_ID LEFT JOIN STUDOMAT.KORISNIK kr ON u.KORISNIK_ID = kr.KORISNIK_ID "
				+ "WHERE kr.KORISNIK_ID = ?");
		

		
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		List<Kolegij> kolegijListUpisani = new ArrayList<>();
		
		while (rs.next()) {
			Kolegij kolegij = new Kolegij();
			kolegij.setId(rs.getInt("ID"));
			kolegij.setNazivKolegija(rs.getString("NAZIV_KOLEGIJA"));
			kolegij.setEcts(rs.getInt("ECTS"));
			if (Kolegij.VRSTA_KOLEGIJA_OBVEZNI_ID == rs.getInt("VRSTA_KOLEGIJA")) {
				kolegij.setVrstaKolegija(VrstaKolegija.OBVEZNI);
			}
			else{
				kolegij.setVrstaKolegija(VrstaKolegija.IZBORNI);
			}
			kolegijListUpisani.add(kolegij);
		}
		
		closeConnectionToDatabase(conn);
		return kolegijListUpisani;
	}
}

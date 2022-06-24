package org.article.dal.jdbc;

import org.article.bo.*;
import org.article.dal.DALException;
import org.article.dal.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitJDBCimpl implements DAO<Produit> {

	private static final String SQL_INSERT="insert into produit (libelle, marque, prixUnitaire, qteStock, type, dateLimiteConso, poids, parfum, temperatureConservation, couleur, typeMine, typeCartePostale) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE="update produit set libelle=?, marque=?, prixUnitaire=?, qteStock=?, type=?, dateLimiteConso=?, poids=?, parfum=?, temperatureConservation=?, couleur=?, typeMine=?, typeCartePostale=? where refProd=?";
	private static final String SQL_DELETE="delete from produit where refProd=?";
	private static final String SQL_SELECT_ALL="select * from produit";
	private static final String SQL_SELECT_BY_ID="select * from produit where refProd=?";
	private static final String SQL_SELECT_AUTEUR_CARTEPOSTALE="select * from auteur_cartepostale where refCartePostale=?";


	@Override
	public void insert(Produit data) throws DALException {

		try (Connection connection = JDBCTools.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {

			preparedStatement.setString(1, data.getLibelle());
			preparedStatement.setString(2, data.getMarque());
			preparedStatement.setFloat(3, data.getPrixUnitaire());
			preparedStatement.setFloat(4, data.getQteStock());

			if (data instanceof Stylo) {

				preparedStatement.setString(5, "Stylo");
				preparedStatement.setDate(6, null);
				preparedStatement.setNull(7, Types.FLOAT);
				preparedStatement.setString(8, null);
				preparedStatement.setNull(9, Types.INTEGER);
				preparedStatement.setString(10, ((Stylo) data).getCouleur());
				preparedStatement.setString(11, ((Stylo) data).getTypeMine());
				preparedStatement.setString(12, null);

			} else if (data instanceof Pain) {

				preparedStatement.setString(5, "Pain");
				preparedStatement.setDate(6, Date.valueOf(((Pain) data).getDateLimiteConso()));
				preparedStatement.setFloat(7, ((Pain) data).getPoids());
				preparedStatement.setString(8, null);
				preparedStatement.setNull(9, Types.INTEGER);
				preparedStatement.setString(10, null);
				preparedStatement.setString(11, null);
				preparedStatement.setString(12, null);

			} else if (data instanceof Glace) {

				preparedStatement.setString(5, "Glace");
				preparedStatement.setDate(6, null);
				preparedStatement.setNull(7, Types.FLOAT);
				preparedStatement.setString(8, ((Glace) data).getParfum());
				preparedStatement.setInt(9, ((Glace) data).getTemperatureConservation());
				preparedStatement.setString(10, null);
				preparedStatement.setString(11, null);
				preparedStatement.setString(12, null);

			} else if (data instanceof CartePostale) {

				preparedStatement.setString(5, "CartePostale");
				preparedStatement.setDate(6, null);
				preparedStatement.setNull(7, Types.FLOAT);
				preparedStatement.setString(8, null);
				preparedStatement.setNull(9, Types.INTEGER);
				preparedStatement.setString(10, null);
				preparedStatement.setString(11, null);
				preparedStatement.setString(12, ((CartePostale) data).getType().toString());

			}

			preparedStatement.executeUpdate();



		} catch (SQLException e) {

			throw new DALException("Erreur lors de l'insertion d'un élément chimique", e);

		}
	}

	@Override
	public void delete (Produit data) throws DALException {
		PreparedStatement pstmt = null;
		Connection cnx=null;
		long id = data.getRefProd();
		cnx = JDBCTools.getConnection();
		try {
			pstmt = cnx.prepareStatement(SQL_DELETE);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("erreur du delete -id= " + id, e.getCause());
		}
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("erreur au niveau du close " + id, e.getCause());
			}
		}
	}

	@Override
	public void update(Produit data) throws DALException {
		PreparedStatement pstmt = null;
		Connection cnx=null;
		long id=data.getRefProd();
		cnx = JDBCTools.getConnection();
		try {
			pstmt = cnx.prepareStatement(SQL_UPDATE);
			pstmt.setLong(5, id);
			pstmt.setString(1, data.getLibelle());
			pstmt.setString(2, data.getMarque());
			pstmt.setFloat(3, data.getPrixUnitaire());
			pstmt.setLong(3, data.getQteStock());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("erreur du update -id= " + id, e.getCause());
		}
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("erreur au niveau du close " + id, e.getCause());
			}
		}

	}

	@Override
	public Produit selectById(long id) throws DALException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Produit el = null;
		//Connection cnx=null;
		Connection cnx = JDBCTools.getConnection();
		try {
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				String type = rs.getString("type");

				switch (type) {
					case "Glace":
						//long refProd, LocalDate datLimiteConso, String marque, String libelle, long qteStock, float prixUnitaire,  String parfum, int temperatureConservation
						el = new Glace(rs.getLong("refProd"), rs.getDate("dateLimiteConso").toLocalDate(), rs.getString("marque"), rs.getString("libelle"), rs.getLong("qteStock"), rs.getFloat("prixUnitaire"),  rs.getString("parfum"), rs.getInt("temperatureConservation"));
						break;

					case "Stylo":
						el = new Stylo(rs.getLong("refProd"), rs.getString("marque"), rs.getString("libelle"), rs.getLong("qteStock"),rs.getFloat("prixUnitaire"), rs.getString("couleur"), rs.getString("typeMine"));
						break;

					case "Pain":
						el = new Pain(rs.getLong("refProd"), rs.getString("marque"), rs.getString("libelle"), rs.getInt("poids"), rs.getLong("qteStock"), rs.getFloat("prixUnitaire"));
						break;
				}
			}
		} catch (SQLException e) {
			throw new DALException("erreur du select by id -id= " + id, e.getCause());
		}
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("erreur au niveau du close " + id, e.getCause());
			}
		}

		return el;
	}

	@Override
	public List<Produit> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		List<Produit> lesProduits = new ArrayList<>();
		Produit produit = null;
		//Connection cnx=null;
		Connection cnx = JDBCTools.getConnection();
		try {
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_ALL);
			while (rs.next()) {

				String type = rs.getString("type");


				if (type.equals("Stylo")) {
					//ong refProd, String marque, String libelle, long qteStock, float prixUnitaire, String couleur, String typeMine
					produit = new Stylo(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getFloat(5),rs.getString(6),rs.getString(7));
				} else if (type.equals("Glace")) {
					//long refProd, LocalDate datLimiteConso, String marque, String libelle, long qteStock, float prixUnitaire,  String parfum, int temperatureConservation
					produit = new Glace(rs.getLong(1),Date.valueOf(rs.getString(7)).toLocalDate() ,rs.getString(3),rs.getString(2),rs.getLong(5),rs.getFloat(4),rs.getString(9),rs.getInt(10));
				} else if (type.equals("Pain")) {
					//long refProd, String marque, String libelle, float poids , long qteStock, float prixUnitaire
					produit = new Pain(rs.getLong(1),rs.getString(3),rs.getString(2),rs.getInt(8),rs.getLong(5),rs.getFloat(4));
				} else if (type.equals("CartePostale")) {

					AuteurJDBCImpl auteurJDBC = new AuteurJDBCImpl();
					List<Auteur> auteurs = new ArrayList<>();

					auteurs.add(auteurJDBC.selectById(rs.getLong(1)));

					System.out.println(auteurs);

					//long refProd, String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> auteurs, TypeCartePostale typeCartePostale
					CartePostale cartePostale = new CartePostale(rs.getLong(1),rs.getString(3),rs.getString(2),rs.getLong(5),rs.getFloat(4),auteurs,TypeCartePostale.valueOf(rs.getString(13)));
				}
				lesProduits.add(produit);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du select all", e.getCause());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DALException("erreur du select all au niveau du close- ", e.getCause());
			}
		}
		return lesProduits;
	}
}

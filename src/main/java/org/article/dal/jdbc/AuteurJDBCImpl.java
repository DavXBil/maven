package org.article.dal.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import  org.article.bo.Auteur;
import  org.article.dal.DALException;
import  org.article.dal.DAO;

public class AuteurJDBCImpl implements DAO<Auteur> {
	private static final String SQL_INSERT="insert into auteur(nom,prenom)VALUES(?,?)";
	private static final String SQL_UPDATE="update auteur set nom=?,prenom=? WHERE id=?";
	private static final String SQL_DELETE="delete from auteur WHERE id=?";
	private static final String SELECT_ALL="select * from auteur";
	private static final String SELECT_BY_ID="select * from auteur WHERE id=?";
	private static final String EXISTE_BY_NOM_PRENOM="select count(*) from auteur where prenom=? and nom=?";
	private static final String SELECT_BY_NOM_PRENOM="select * from auteur where prenom=? and nom=?";
	private static final String SELECT_BY_REF_PROD="select auteur.* from auteur inner join auteur_carte_postale "
			+ "on auteur.id=auteur_carte_postale.auteur_id where carte_postale_ref_prod=?";

	@Override
	public void insert(Auteur data) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		Connection cnx = JDBCTools.getConnection();
		long id=0;
		try {
			pstmt=cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getNom());
			pstmt.setString(2, data.getPrenom());
			int nbRow=pstmt.executeUpdate();
			if (nbRow==1)
			{
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					data.setId(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du insert -data="+data,e.getCause());
		}
		finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du insert au niveau du close- data=" + data, e.getCause());
            }
		}
		
		
		
	}

	@Override
	public void delete(Auteur data) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		Connection cnx = JDBCTools.getConnection();
		long id=data.getId();
			try {
				pstmt= cnx.prepareStatement(SQL_DELETE);
				pstmt.setLong(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DALException("erreur du delete -data="+data,e.getCause());
			}
			finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	            } catch (SQLException e) {
	                throw new DALException("erreur du delete au niveau du close- data=" + data, e.getCause());
	            }
			}
			
		}

	@Override
	public void update(Auteur data) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		Connection cnx = JDBCTools.getConnection();
		long id=data.getId();
		try {
			pstmt= cnx.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, data.getNom());
			pstmt.setString(2, data.getPrenom());
			pstmt.setLong(3, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du update -data="+data,e.getCause());
		}
		finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du update au niveau du close- data=" + data, e.getCause());
            }
		}
		
	}

	@Override
	public Auteur selectById(long id) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		Auteur auteur=null;
		Connection cnx = JDBCTools.getConnection();
		try {
			pstmt=cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				auteur = new Auteur(rs.getLong(1),rs.getString(3),rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du select by id -id="+id,e.getCause());
		}
		finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du select by id au niveau du close- id=" + id, e.getCause());
            }
		}
		
		return auteur;
	}

	@Override
	public List<Auteur> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Statement stmt=null;
		ResultSet rs= null;
		List<Auteur> lesAuteurs= new ArrayList<>();
		Auteur auteur = null;
		Connection cnx = JDBCTools.getConnection();
		try {
			stmt=cnx.createStatement();
			rs= stmt.executeQuery(SELECT_ALL);
			while(rs.next())
			{
				auteur = new Auteur(rs.getLong(1),rs.getString(3),rs.getString(2));
				lesAuteurs.add(auteur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du select by all",e.getCause());
		}
		finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du select by id au niveau du close", e.getCause());
            }
		}
		
		return lesAuteurs;
	}
	public Auteur selectByNomPrenom(String prenom,String nom) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		Auteur auteur=null;
		Connection cnx = JDBCTools.getConnection();
		try {
			pstmt=cnx.prepareStatement(SELECT_BY_NOM_PRENOM);
			pstmt.setString(1, prenom);
			pstmt.setString(2, nom);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				auteur = new Auteur(rs.getLong(1),rs.getString(3),rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du select by nom prenom -nom="+nom+",prenom="+prenom,e.getCause());
		}
		finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du select by by nom prenom -nom="+nom+",prenom="+prenom, e.getCause());
            }
		}
		
		return auteur;
	}
	public boolean existeByNomPrenom(String prenom,String nom) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		Auteur auteur=null;
		boolean existe=false;
		Connection cnx = JDBCTools.getConnection();
		try {
			pstmt=cnx.prepareStatement(EXISTE_BY_NOM_PRENOM);
			pstmt.setString(1, prenom);
			pstmt.setString(2, nom);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getInt(1)>=1)
				{
					existe=true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du select by nom prenom -nom="+nom+",prenom="+prenom,e.getCause());
		}
		finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du select by by nom prenom -nom="+nom+",prenom="+prenom, e.getCause());
            }
		}
		
		return existe;
	}
	public List<Auteur> selectByRefProd(long refProd) throws DALException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		List<Auteur> lesAuteurs= new ArrayList<>();
		Auteur auteur = null;
		Connection cnx = JDBCTools.getConnection();
		try {
			pstmt=cnx.prepareStatement(SELECT_BY_REF_PROD);
			pstmt.setLong(1, refProd);
			rs= pstmt.executeQuery();
			while(rs.next())
			{
				auteur = new Auteur(rs.getLong(1),rs.getString(3),rs.getString(2));
				lesAuteurs.add(auteur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur du select by ref prod refprod="+refProd,e.getCause());
		}
		finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new DALException("erreur du select by select by ref prod au niveau du close refProd="+refProd, e.getCause());
            }
		}
		
		return lesAuteurs;
	}

}

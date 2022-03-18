package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Ramette;
import bo.Stylo;
import dal.Connexion;

public class ArticleDAO {
	public List<Article> selectAll() {
		Connection cnx = Connexion.getCnx();
		List<Article> stock = new ArrayList<Article>();
		String sql = "SELECT * from article";
		try {
			Statement state = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(sql);
		
			while(result.next()) {
				if(result.getString("type").equals("stylo")) {
					Stylo s = new Stylo();
					s.setIdArticle(result.getInt("id"));
					s.setReference(result.getString("reference"));
					s.setMarque(result.getString("marque"));
					s.setDesignation(result.getString("designation"));
					s.setPrixUnitaire(result.getFloat("prixUnitaire"));
					s.setQteStock(result.getInt("qteStock"));
					s.setCouleur(result.getString("couleur"));
					stock.add(s);
				}else {
				Ramette r = new Ramette();
					r.setIdArticle(result.getInt("id"));
					r.setReference(result.getString("reference"));
					r.setMarque(result.getString("marque"));
					r.setDesignation(result.getString("designation"));
					r.setPrixUnitaire(result.getFloat("prixUnitaire"));
					r.setQteStock(result.getInt("qteStock"));
					r.setGrammage(result.getInt("grammage"));
					stock.add(r);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
//		Connexion.deconnexion(cnx);
		return stock;
	}
	
	public void insert(Article a) {
		Connection cnx = Connexion.getCnx();
		if(a.getClass().getSimpleName().equals("Stylo")) {
			String sqlPrepared = "INSERT INTO `article` VALUES (NULL, ?, ?, ?, ?, ?, NULL, ?, ?)";
			//Statement : 
			try {
				PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, a.getReference());
				pStmt.setString(2, a.getMarque());
				pStmt.setString(3, a.getDesignation());
				pStmt.setFloat(4, a.getPrixUnitaire());
				pStmt.setInt(5, a.getQteStock());
				pStmt.setString(6, ((Stylo) a).getCouleur());
				pStmt.setString(7, a.getClass().getSimpleName());
				pStmt.executeUpdate();
				ResultSet resultset = pStmt.getGeneratedKeys();
				resultset.next();
				a.setIdArticle(resultset.getInt(1));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			String sqlPrepared = "INSERT INTO `article` VALUES (NULL, ?, ?, ?, ?, ?, ?, NULL, ?)";
			//Statement : 
			try {
				PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, a.getReference());
				pStmt.setString(2, a.getMarque());
				pStmt.setString(3, a.getDesignation());
				pStmt.setFloat(4, a.getPrixUnitaire());
				pStmt.setInt(5, a.getQteStock());
				pStmt.setInt(6, ((Ramette) a).getGrammage());
				pStmt.setString(7, a.getClass().getSimpleName());
				pStmt.executeUpdate();
				ResultSet resultset = pStmt.getGeneratedKeys();
				resultset.next();
				a.setIdArticle(resultset.getInt(1));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		public void delete(Article a) {
			Connection cnx = Connexion.getCnx();
			if(a.getClass().getSimpleName().equals("Stylo")) {
				String sqlPrepared = "INSERT INTO `article` VALUES (NULL, ?, ?, ?, ?, ?, NULL, ?, ?)";
				//Statement : 
				try {
					PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
					pStmt.setString(1, a.getReference());
					pStmt.setString(2, a.getMarque());
					pStmt.setString(3, a.getDesignation());
					pStmt.setFloat(4, a.getPrixUnitaire());
					pStmt.setInt(5, a.getQteStock());
					pStmt.setString(6, ((Stylo) a).getCouleur());
					pStmt.setString(7, a.getClass().getSimpleName());
					pStmt.executeUpdate();
					ResultSet resultset = pStmt.getGeneratedKeys();
					resultset.next();
					a.setIdArticle(resultset.getInt(1));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				String sqlPrepared = "INSERT INTO `article` VALUES (NULL, ?, ?, ?, ?, ?, ?, NULL, ?)";
				//Statement : 
				try {
					PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
					pStmt.setString(1, a.getReference());
					pStmt.setString(2, a.getMarque());
					pStmt.setString(3, a.getDesignation());
					pStmt.setFloat(4, a.getPrixUnitaire());
					pStmt.setInt(5, a.getQteStock());
					pStmt.setInt(6, ((Ramette) a).getGrammage());
					pStmt.setString(7, a.getClass().getSimpleName());
					pStmt.executeUpdate();
					ResultSet resultset = pStmt.getGeneratedKeys();
					resultset.next();
					a.setIdArticle(resultset.getInt(1));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		Connexion.deconnexion(cnx);
	}
}

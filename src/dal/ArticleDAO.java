package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import bo.Ramette;
import bo.Article;
import bo.Stylo;

public class ArticleDAO {

	public Article selectById(int id) {
		Article a = null;
		Connection cnx = Connexion.getCnx();
		String sqlPrepared = "SELECT * FROM article WHERE id = ?";
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared);
			pStmt.setInt(1, id); // binder
			// pStmt.executeUpdate();
			ResultSet rs = pStmt.executeQuery();
			rs.next(); // extraire de la pile
			if (rs.getString("type").equals("ramette")) {
				Ramette r = new Ramette();
				r.setIdArticle(rs.getInt("id"));
				r.setReference(rs.getString("reference"));
				r.setMarque(rs.getString("marque"));
				r.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				r.setQteStock(rs.getInt("qteStock"));
				r.setDesignation(rs.getString("designation"));
				r.setGrammage(rs.getInt("grammage"));
				a = r;
			} else if (rs.getString("type").equals("stylo")) {
				Stylo s = new Stylo();
				s.setIdArticle(rs.getInt("id"));
				s.setReference(rs.getString("reference"));
				s.setMarque(rs.getString("marque"));
				s.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				s.setQteStock(rs.getInt("qteStock"));
				s.setDesignation(rs.getString("designation"));
				s.setCouleur(rs.getString("couleur"));
				a = s;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// a = s;
		// a = r;
		return a;
	}

	public List<Article> selectAll() {
		List<Article> articles = new ArrayList<Article>();
		Connection cnx = Connexion.getCnx();
		Article a = null;
		String sql = "SELECT * from article";
		try {

			Statement state = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			// j excecute ma query
			ResultSet rs = state.executeQuery(sql);
			// tant qu'il y a des lignes ds la pile : je boucle
			while (rs.next()) {
				if (rs.getString("type").equals("ramette")) {
					Ramette r = new Ramette();
					r.setIdArticle(rs.getInt("id"));
					r.setReference(rs.getString("reference"));
					r.setMarque(rs.getString("marque"));
					r.setPrixUnitaire(rs.getFloat("prixUnitaire"));
					r.setQteStock(rs.getInt("qteStock"));
					r.setDesignation(rs.getString("designation"));
					r.setGrammage(rs.getInt("grammage"));
					a = r;
				} else if (rs.getString("type").equals("stylo")) {
					Stylo s = new Stylo();
					s.setIdArticle(rs.getInt("id"));
					s.setReference(rs.getString("reference"));
					s.setMarque(rs.getString("marque"));
					s.setPrixUnitaire(rs.getFloat("prixUnitaire"));
					s.setQteStock(rs.getInt("qteStock"));
					s.setDesignation(rs.getString("designation"));
					s.setCouleur(rs.getString("couleur"));
					a = s;
				}
				articles.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return articles;
	}

	public void update(Article a) {
		Connection cnx = Connexion.getCnx();
		String sqlPrepared = "UPDATE personne";
		sqlPrepared += " SET reference= ?,";
		sqlPrepared += " SET marque=?,";
		sqlPrepared += " SET designation=?,";
		sqlPrepared += " SET prixUnitaire=?,";
		sqlPrepared += " SET qteStock=?,"; // 5
		sqlPrepared += " SET grammage=?,"; // 6
		sqlPrepared += " SET couleur=? "; // 7
		sqlPrepared += " SET type=? "; // 8
		sqlPrepared += " WHERE id=?"; // 9

		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared);

			pStmt.setString(1, a.getReference());
			pStmt.setString(2, a.getMarque());
			pStmt.setString(3, a.getDesignation());
			pStmt.setFloat(4, a.getPrixUnitaire());
			pStmt.setInt(5, a.getQteStock());
			pStmt.setInt(9, a.getIdArticle());

			if (a instanceof Ramette) {
				Ramette r = (Ramette) a;
				pStmt.setInt(6, r.getGrammage());
				pStmt.setNull(7, Types.NULL);
				pStmt.setString(8, "ramette");
			} else if (a instanceof Stylo) {
				Stylo s = (Stylo) a;
				pStmt.setNull(6, Types.NULL);
				pStmt.setString(7, s.getCouleur());
				pStmt.setString(8, "ramette");
			}
			pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(Article a) {
		Connection cnx = Connexion.getCnx();
		String sqlPrepared = "INSERT INTO article VALUES (NULL,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
			// binder
			// Valoriser les parametres de la requete
			// 1 => premier ?
			// pStmt.setString(1, p.getPrenom());
			pStmt.setString(1, a.getReference());
			pStmt.setString(2, a.getMarque());
			pStmt.setString(3, a.getDesignation());
			pStmt.setFloat(4, a.getPrixUnitaire());
			pStmt.setInt(5, a.getQteStock());

			if (a instanceof Ramette) {
				Ramette r = (Ramette) a;
				pStmt.setInt(6, r.getGrammage());
				pStmt.setNull(7, Types.NULL);
				pStmt.setString(8, "ramette");
			} else if (a instanceof Stylo) {
				Stylo s = (Stylo) a;
				pStmt.setNull(6, Types.NULL);
				pStmt.setString(7, s.getCouleur());
				pStmt.setString(8, "ramette");
			}
			
			pStmt.executeUpdate();
			// --- id ????
			// on demande l id donné par l base
			ResultSet rs = pStmt.getGeneratedKeys();
			rs.next(); // enlever de la pile
			a.setIdArticle(rs.getInt(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		Connection cnx = Connexion.getCnx();
		String sqlPrepared = "DELETE FROM article WHERE id = ?";
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared);
			pStmt.setInt(1, id);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

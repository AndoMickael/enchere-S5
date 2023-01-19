package mg.groupe26.model;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Produit {

    String id;
    String nom;
    String descri;
    Double prix;
    String proprietaireid;
    String categorieid;

    public Produit() {
    }

    public Produit(String id, String nom, String descri, Double prix, String proprietaireid, String categorieid) {
        this.id = id;
        this.nom = nom;
        this.descri = descri;
        this.prix = prix;
        this.proprietaireid = proprietaireid;
        this.categorieid = categorieid;
    }

    public String getProprietaireid() {
        return proprietaireid;
    }

    public void setProprietaireid(String proprietaireid) {
        this.proprietaireid = proprietaireid;
    }

    public String getCategorieid() {
        return categorieid;
    }

    public void setCategorieid(String categorieid) {
        this.categorieid = categorieid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public List<Produit> select(String query, JdbcTemplate jt) {
        return jt.query(query, (rs, row) -> new Produit(
                rs.getString("id"),
                rs.getString("nom"),
                rs.getString("descri"),
                rs.getDouble("prix"),
                rs.getString("propietaireid"),
                rs.getString("categorieid")));
    }
    
    public Produit selectById(JdbcTemplate jt) {
        String query = String.format("select * from Produit where id = '%s' ", getId());
        return (select(query, jt).get(0));
    }

    public void insert(JdbcTemplate jt) {
        String query = String.format("insert into produit values (concat('Produit',nextval('seq_produit')), '%s', '%s', %s, '%s', '%s')", getNom(), getDescri(), getPrix(), getProprietaireid(), getCategorieid());
        jt.update(query);
    }

    public void update(JdbcTemplate j, Produit p) {
        String query = String.format("update produit set nom='%s',descri='%s',prix=%s,proprietaireid='%s',categorieid='%s' where id='%s'", getNom(), getDescri(), getPrix(), getProprietaireid(), getCategorieid(), getId());
        j.update(query);
    }

}

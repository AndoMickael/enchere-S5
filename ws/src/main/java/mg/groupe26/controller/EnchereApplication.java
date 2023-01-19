package mg.groupe26.controller;

import java.util.List;
import mg.groupe26.model.Admin;
import mg.groupe26.model.Categorie;
import mg.groupe26.model.Config;
import mg.groupe26.model.Enchere;
import mg.groupe26.model.Photo;
import mg.groupe26.model.Produit;
import mg.groupe26.model.RechargeCompte;
import mg.groupe26.model.ResultatEnchere;
import mg.groupe26.model.Token;
import mg.groupe26.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin
public class EnchereApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EnchereApplication.class, args);
    }

//    test
    @GetMapping("/hello")
    public String hello() {
        return ("Hello !");
    }

//    utilisateur
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getListUtlisateur() {
        return (new Utilisateur().select("select * from Utilisateur", jdbcTemplate));
    }

    @GetMapping("/loginUtilisateur")
    public Utilisateur loginUtilisateur(@RequestParam String email,
            @RequestParam String mdp) {
        return (new Utilisateur(null, null, null, email, mdp).login(jdbcTemplate));
    }
    
    @GetMapping("/inscription")
    public void addUtilisateur(@RequestParam String nom,
            @RequestParam String pseudo,
            @RequestParam String email,
            @RequestParam String mdp) {
        new Utilisateur(null, nom, pseudo, email, mdp).insert(jdbcTemplate);
    }

//    admin
    @GetMapping("/admins")
    public List<Admin> getListAdmin() {
        return (new Admin().select("select * from Admin", jdbcTemplate));
    }

    @GetMapping("/loginAdmin")
    public Admin loginAdmin(@RequestParam String email,
            @RequestParam String mdp) {
        return (new Admin(null, email, mdp).login(jdbcTemplate));
    }

    @GetMapping("/addAdmin")
    public void addAdmin(@RequestParam String email,
            @RequestParam String mdp) {
        new Admin(null, email, mdp).insert(jdbcTemplate);
    }

//    enchere
    @GetMapping("/encheres")
    public List<Enchere> getListEnchere() {
        return (new Enchere().select("select * from Enchere", jdbcTemplate));
    }

    @GetMapping("/addEnchere")
    public void addEnchere(@RequestParam String duree,
            @RequestParam double prixMin,
            @RequestParam int status,
            @RequestParam String produitId) {
        new Enchere().insert(jdbcTemplate);
    }

    @GetMapping("/updateEnchere")
    public void updateEnchere() {
        new Enchere().update(jdbcTemplate);
    }

//    produit
    @GetMapping("/produits")
    public List<Produit> getProduit() {
        return (new Produit().select("select * from Produit", jdbcTemplate));
    }
    
    @GetMapping("/produits/{id}")
    public Produit getProduitById(@PathVariable String id) {
        return (new Produit(id, null, null, null, null, null).selectById(jdbcTemplate));
    }

    @GetMapping("/addProduit")
    public void addProduit() {
        new Produit().insert(jdbcTemplate);
    }

//    rechargeCompte
    @GetMapping("/rechargeComptes")
    public List<RechargeCompte> getListRechargeCompte() {
        return (new RechargeCompte().select("select * from rechargecompte", jdbcTemplate));
    }

    @GetMapping("/addRechargeCompte")
    public void addRechargeCompte(@RequestParam double montant,
            @RequestParam String utilisateurId) {
        new RechargeCompte(null, utilisateurId, montant, null, null).insert(jdbcTemplate);
    }
    
    @GetMapping("/acceptRechargeCompte/{id}")
    public void acceptRechargeCompte(@PathVariable String id) {
        new RechargeCompte(id, null, null, 1, null).update(jdbcTemplate);
    }
    
    @GetMapping("/refuseRechargeCompte/{id}")
    public void refuseRechargeCompte(@PathVariable String id) {
        new RechargeCompte(id, null, null, -1, null).update(jdbcTemplate);
    }

//    resultatEnchere
    @GetMapping("/resultatenchere")
    public List<ResultatEnchere> getResultatEnchere() {
        return (new ResultatEnchere().select("select * from resultatenchere", jdbcTemplate));
    }

    @GetMapping("/addResultatEnchere")
    public void addResultatEnchere() {
        new ResultatEnchere().insert(jdbcTemplate);
    }

//    photo
    @GetMapping("/photo")
    public List<Photo> getPhoto() {
        return (new Photo().select("select * from photo", jdbcTemplate));
    }

    @GetMapping("/addPhoto")
    public void addPhoto() {
        new Photo().insert(jdbcTemplate);
    }

//    categorie
    @GetMapping("/categorie")
    public List<Categorie> getCategorie() {
        return (new Categorie().select("select * from categorie", jdbcTemplate));
    }

    @GetMapping("/addCategorie")
    public void addCategorie() {
        new Categorie().insert(jdbcTemplate);
    }

//    config
    @GetMapping("/addConfig")
    public void addConfig() {
        new Config().insert(jdbcTemplate);
    }

//    token
    @GetMapping("/addToken")
    public void addToken() {
        new Token().insert(jdbcTemplate);
    }

}

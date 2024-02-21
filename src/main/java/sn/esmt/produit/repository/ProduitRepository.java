package sn.esmt.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.esmt.produit.entity.ProduitEntity;

import java.util.Optional;
@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity,String > {
  @Query("select p from ProduitEntity p where p.ref = ?1 and p.quant = ?2")
  public Optional<ProduitEntity> findByReferenceAndQuantite(String ref, double quantite);

  @Query("select p from ProduitEntity p where p.ref = :r and p.quant = :q")
  public Optional<ProduitEntity> findByReferenceAndQuantitev2(@Param("r")String ref, @Param("q") double quantite);
  public Optional<ProduitEntity> findByRef(String ref);
}

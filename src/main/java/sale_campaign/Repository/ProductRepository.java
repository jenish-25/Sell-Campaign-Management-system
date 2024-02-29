package sale_campaign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sale_campaign.Model.ProductData;

@Repository
public interface ProductRepository extends JpaRepository<ProductData,String>{
}

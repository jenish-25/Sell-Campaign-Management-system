package sale_campaign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sale_campaign.Model.DiscountDetails;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountDetails,Integer> {
}

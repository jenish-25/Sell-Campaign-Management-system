package sale_campaign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sale_campaign.Model.PriceHistory;

import java.util.List;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory,Integer> {
    List<PriceHistory> findAllByProductId(String productId);
}

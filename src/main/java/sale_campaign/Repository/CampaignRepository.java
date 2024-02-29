package sale_campaign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sale_campaign.Model.SaleCampaignData;

@Repository
public interface CampaignRepository extends JpaRepository<SaleCampaignData,Integer> {
}

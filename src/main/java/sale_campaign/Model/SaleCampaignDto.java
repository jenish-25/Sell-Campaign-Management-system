package sale_campaign.Model;

import lombok.Data;

import java.util.List;

@Data
public class SaleCampaignDto {
    private String title;
    private String startDate;
    private String endDate;
    List<DiscountDetails> campaignDiscount;
}

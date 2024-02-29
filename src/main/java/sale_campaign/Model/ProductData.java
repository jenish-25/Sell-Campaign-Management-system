package sale_campaign.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "product_data")
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {

    @Id
    String ProductId;
    String Title;
    long mrp;
    long currentPrice;
    long discount;
    int inventory;

    public void setProductId() {
        UUID uuid=UUID.randomUUID();
        String uuidString=uuid.toString().replace("-","");
        this.ProductId=uuidString.substring(0,5);
    }
}

package sale_campaign.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import sale_campaign.Model.*;
import sale_campaign.Service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("addProduct")
    public ResponseEntity<List<ProductData>> addProduct(@RequestBody List<ProductData> productDataList){
        return productService.addProduct(productDataList);
    }

    @GetMapping("getDetailsById")
    public ResponseEntity<Optional<ProductData>> getProductDetails(@RequestParam String productId){
        return productService.getProductDetails(productId);
    }

    @GetMapping("AllData")
    public ResponseEntity<List<ProductData>> allData(){
        return productService.allData();
    }

    @GetMapping("getPageData")
    public List<ProductData> getData(@RequestBody PageData pageData){
        return productService.getData(pageData);
    }

    @PostMapping("saveCampaign")
    public SaleCampaignDto addCampaignData(@RequestBody SaleCampaignDto saleCampaignDto){
        return productService.addCampaignData(saleCampaignDto);
    }

    @Scheduled(cron = "0 59 13 ? * *")
    public void triggerDiscount(){
        productService.triggerDiscount();
    }

    @Scheduled(cron = "0 59 14 ? * *")
    public void unTriggerDiscount(){
        productService.unTriggerDiscount();
    }

    @GetMapping("getHistory")
    public List<PriceHistory> getHistory(@RequestParam String productId){
        return productService.getHistory(productId);
    }

    @GetMapping("PastCampaign")
    public List<SaleCampaignData> pastCampaign(){
        return productService.pastCampaign();
    }
    @GetMapping("currCampaign")
    public List<SaleCampaignData> currCampaign(){
        return productService.currCampaign();
    }
    @GetMapping("upcomingCampaign")
    public List<SaleCampaignData> upcomingCampaign(){
        return productService.upcomingCampaign();
    }
}

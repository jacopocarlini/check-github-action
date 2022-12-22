package src.main.java.it.gov.pagopa.afm.calculator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.gov.pagopa.afm.calculator.entity.Touchpoint;
import it.gov.pagopa.afm.calculator.entity.ValidBundle;
import it.gov.pagopa.afm.calculator.service.ConfigurationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/configuration")
@Tag(name = "Configuration", description = "Utility Services")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @PostMapping("/bundles/add")
    public ResponseEntity<Void> addValidBundles(@RequestBody List<ValidBundle> validBundles) {
        configurationService.addValidBundles(validBundles);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/bundles/delete")
    public ResponseEntity<Void> deleteValidBundles(@RequestBody List<ValidBundle> validBundles) {
        configurationService.deleteValidBundles(validBundles);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/touchpoint/add")
    public ResponseEntity<Void> addTouchpoints(@RequestBody List<Touchpoint> touchpoints) {
        configurationService.addTouchpoints(touchpoints);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/touchpoint/delete")
    public ResponseEntity<Void> deleteTouchpoints(@RequestBody List<Touchpoint> touchpoints) {
        configurationService.deleteTouchpoints(touchpoints);
        return ResponseEntity.ok().build();
    }
}

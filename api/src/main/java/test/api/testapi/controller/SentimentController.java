package test.api.testapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test.api.testapi.entites.Sentiment;
import test.api.testapi.enums.TypeSentiment;
import test.api.testapi.services.SentimentServices;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment",produces = MediaType.APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentServices sentimentServices;

    public SentimentController setSentimentServices(SentimentServices sentimentServices) {
        this.sentimentServices = sentimentServices;
        return this;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void ceer(@RequestBody  Sentiment sentiment){
        this.sentimentServices.creer(sentiment);

    }
    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentServices.rechercher(type);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public  void supprimer(@PathVariable int id){
        this.sentimentServices.supprimer(id);

    }
}
